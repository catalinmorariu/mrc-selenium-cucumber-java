package net.metrosystems.mrc.stepdefinitions;

import com.codeborne.selenide.CollectionCondition;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class LaunchPad {

    @Then("go to {string} tile at launchpad")
    public void gotToTile(String tileName) {
        String[] href = new String[1];
        $$(".mrc-tile")
            .shouldBe(CollectionCondition.anyMatch("reportTile",
                webElement -> {
                    href[0] = webElement.getAttribute("href");
                    return href[0] != null && href[0].contains(tileName);
                }));
        open(href[0]);
    }
}
