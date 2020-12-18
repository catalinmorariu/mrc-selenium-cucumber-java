package net.metrosystems.mrc.stepdefinitions;

import com.codeborne.selenide.CollectionCondition;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class Search {
    @Then("enter {string} into {string} and pick it from the list")
    public void enterValue2ElementWithId(String searchedValue, String searchId) {
        $(By.id(searchId)).shouldBe(visible).setValue(searchedValue).pressEnter();
        String[] href = new String[1];
        $$(".mrc-search-result")
            .shouldBe(CollectionCondition.anyMatch("search item",
                webElement -> {
                    WebElement link = webElement.findElement(By.tagName("a"));
                    href[0] = link.getAttribute("href");
                    return href[0] != null && href[0].endsWith(searchedValue);
                })).first().shouldBe(visible);
        open(href[0]);
    }
}
