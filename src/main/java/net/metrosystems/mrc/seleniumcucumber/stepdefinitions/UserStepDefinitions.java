package net.metrosystems.mrc.seleniumcucumber.stepdefinitions;

import io.cucumber.java.en.Then;
import net.metrosystems.mrc.env.DriverUtil;

import java.util.concurrent.TimeUnit;

import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.INPUT_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.MISC_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.NAVIGATE_METHODS;

public class UserStepDefinitions {
    private static volatile String host;
    private static volatile String user;
    private static volatile String password;
    private static volatile int defaultTimeout;
    //Prerequisite Steps

    @Then("^I want to test against \"([^\"]*)\"$")
    public void setHostToUse(String host) {
        synchronized (UserStepDefinitions.class) {
            UserStepDefinitions.host = host;
        }
    }

    @Then("^I want to use user \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void setCredentialsToUse(String user, String password) {
        synchronized (UserStepDefinitions.class) {
            UserStepDefinitions.user = user;
            UserStepDefinitions.password = password;
        }
    }

    @Then("^I want to use default timeout (\\d+) seconds for each operation$")
    public void setTimeoutToUse(int timeoutInSeconds) {
        synchronized (UserStepDefinitions.class) {
            UserStepDefinitions.defaultTimeout = timeoutInSeconds;
            DriverUtil.getDefaultDriver().manage().timeouts().setScriptTimeout(timeoutInSeconds,
                TimeUnit.SECONDS);
        }
    }

    @Then("^I go to the host$")
    public void goToHost() {
        NAVIGATE_METHODS.navigateTo(host);
    }

    @Then("^I enter (user|password) into input field having (.+) \"([^\"]*)\"$")
    public void enterCredentials(String credentials, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.enterText(type, "user".equals(credentials) ? user : password, accessName);
    }
}
