package net.metrosystems.mrc.stepdefinitions;

import com.codeborne.selenide.CollectionCondition;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Reports {
    @Then("^go to report \"([^\"]*)\" and wait$")
    public void goToReport(String reportName) {
        String[] text = new String[1];
        WebElement[] link = new WebElement[1];
        $$(".mrc-ui-report")
            .shouldBe(CollectionCondition.anyMatch("report", webElement -> {
                WebElement textElem = webElement.findElement(By.cssSelector(".mrc-ui-report-text"));
                text[0] = textElem.getText();
                link[0] = webElement.findElement(By.tagName("a"));
                return text[0] != null && text[0].startsWith(reportName);
            }));
        link[0].click();
        $(".mrc-iframe").shouldHave(text(text[0]));
    }
}
