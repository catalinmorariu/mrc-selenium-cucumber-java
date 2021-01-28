package net.metrosystems.mrc.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
//
//public class QuickCheck {
//
//    private static final Logger LOG = LoggerFactory.getLogger(QuickCheck.class);
//
//    public static final String QUICK_CHECK_BUTTON = "mrc-primary-button undefined";
//
//
//@Then("there should be {string} button and I click it")
//public void checkQcButtonAndClick(String value) {
//    LOG.info("inside");
//    clickQC(value, QUICK_CHECK_BUTTON);
//    }
//
//private void clickQC(String value, String QUICK_CHECK_BUTTON) {
//    $(By.className("mrc-primary-button undefined")).click();
//    }
//    }
