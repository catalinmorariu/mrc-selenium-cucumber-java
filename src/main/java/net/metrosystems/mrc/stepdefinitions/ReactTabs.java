package net.metrosystems.mrc.stepdefinitions;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReactTabs {

    public static final String MRC_MAIN = "mrc-main";
    public static final String REACT_TABS = "react-tabs";
    public static final String INNER_HTML = "innerHTML";
    public static final String REACT_TABS_TAB = "react-tabs__tab";
    public static final String SELECTED_REACT_TAB = "react-tabs__tab-panel--selected";

    @Then("there should be {string} button and I click it")
    public void checkCreateButtonAndClick(String value) {
        clickCreateOrEditRequest(value);
    }

    @Then("if there is a running request then click {string} and cancel it via {string} button")
    public void clickEditAndCancel(String button1, String button2) {
        SelenideElement button = $(By.className(MRC_MAIN))
            // exactly this button is inside innerHTML => need firstly wait when it is loaded
            .shouldBe(visible).shouldHave(Condition.attribute(INNER_HTML))
            .$$(By.className(ButtonTypes.fromText(button1).getCssClassName()))
            .first().shouldBe(visible);

        if (button1.equalsIgnoreCase(button.getText())) {
            clickCreateOrEditRequest(button1);
            // trick to wait for react specific tags loading on the page
            $(By.className(MRC_MAIN)).shouldBe(visible).shouldHave(Condition.attribute(INNER_HTML))
                .$(By.className(REACT_TABS)).shouldBe(visible)
                .$(By.className(SELECTED_REACT_TAB)).shouldBe(visible)
                .$(By.className("mrc-ui-toggle-box-content")).shouldBe(visible);
            clickCreateOrEditRequest(button2);
        }
    }

    @Then("go to {string} tab")
    public void goToTab(String tabName) {
        $(By.className(MRC_MAIN))
            // this button is inside innerHTML => need firstly wait when it is loaded
            .shouldBe(visible).shouldHave(Condition.attribute(INNER_HTML))
            .$(By.className(REACT_TABS)).shouldBe(visible)
            .$$(By.className(REACT_TABS_TAB)).findBy(Condition.text(tabName))
            .shouldBe(Condition.attribute("role", "tab")).click();
    }

    @Then("for customer {string} set {string} limit {string} {int}")
    public void setLimitForCustomer(String customer, String limitType, String amount, int limit) {
        SelenideElement requestedItem = $(By.className(MRC_MAIN))
            // exactly this button is inside innerHTML => need firstly wait when it is loaded
            .shouldBe(visible).shouldHave(Condition.attribute(INNER_HTML))
            .$(By.className(REACT_TABS)).shouldBe(visible)
            .$(By.className("mrc-ui-table-d")).shouldBe(visible);
        requestedItem
            .$$(By.tagName("span")).findBy(Condition.text(customer))
            .shouldBe(visible).click();

        System.out.println(requestedItem);
        System.out.println(requestedItem.$$(By.className("mrc-ui-check-card-title")));
        requestedItem.$$(By.className("mrc-ui-check-card-title"))
            .findBy(Condition.text(limitType)).shouldBe(visible).click();

        requestedItem.$$(By.className("mrc-ui-card")).findBy(Condition.text(amount))
            .$(By.xpath("/../")).$(By.tagName("input")).setValue(String.valueOf(limit));
    }

    @Then("check presence of {string} tabs")
    public void checkTabsPresence(String tabNames) {
        Set<String> expectedTabNames = Arrays.stream(tabNames.split(","))
            .map(String::trim).map(t -> t.toUpperCase(Locale.ROOT)).collect(Collectors.toSet());
        Set<String> presentedTabNames = $(By.className(MRC_MAIN))
            // exactly this button is inside innerHTML => need firstly wait when it is loaded
            .shouldBe(visible).shouldHave(Condition.attribute(INNER_HTML))
            .$(By.className(REACT_TABS)).shouldBe(visible)
            .$$(By.className(REACT_TABS_TAB)).shouldBe(
                CollectionCondition.allMatch("tabs only",
                    t -> "tab".equalsIgnoreCase(t.getAttribute("role"))))
            .texts().stream().map(t -> t.toUpperCase(Locale.ROOT)).collect(Collectors.toSet());
        assert presentedTabNames.containsAll(expectedTabNames);
    }

    private void clickCreateOrEditRequest(String value) {
        $(By.className(MRC_MAIN))
            // exactly this button is inside innerHTML => need firstly wait when it is loaded
            .shouldBe(visible).shouldHave(Condition.attribute(INNER_HTML))
            .$(By.className(ButtonTypes.fromText(value).getCssClassName()))
            .shouldBe(visible).shouldHave(Condition.text(value)).click();
    }

    public enum ButtonTypes {
        BLUE("mrc-primary-button", "blue", "request credit", "edit"),
        GREY("mrc-secondary-button", "grey", "cancel");
        private final String cssClassName;
        private final String color;
        private final Set<String> buttonText;

        ButtonTypes(String cssClassName, String color, String... buttonText) {
            this.cssClassName = cssClassName;
            this.color = color;
            this.buttonText = buttonText.length == 0
                ? Collections.emptySet()
                : Stream.of(buttonText)
                .map(t -> t.toUpperCase(Locale.ROOT)).collect(Collectors.toSet());
        }

        public static ButtonTypes fromText(String btnText) {
            for (ButtonTypes btnType : values()) {
                if (btnType.buttonText.contains(btnText.toUpperCase(Locale.ROOT))) {
                    return btnType;
                }
            }
            throw new RuntimeException("Button with button text " + btnText + " is not configured");
        }

        public String getCssClassName() {
            return cssClassName;
        }

        public String getColor() {
            return color;
        }
    }
}
