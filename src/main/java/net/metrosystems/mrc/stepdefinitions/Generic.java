package net.metrosystems.mrc.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Generic {
    private static final Duration DEFAULT_TIMEOUT = Duration.of(120, ChronoUnit.SECONDS);
    private static volatile String host;
    private static volatile String user;
    private static volatile String password;
    private static final Properties USER_PASS = new Properties();

    //Prerequisite Steps
    static {
        Configuration.timeout = DEFAULT_TIMEOUT.getSeconds() * 1000;
        try (InputStream iStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("users.properties")) {
            // Loading properties file from the path (relative path given here)
            USER_PASS.load(iStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("I want to test against {string}")
    public void goToHost(String host) {
        synchronized (Generic.class) {
            Generic.host = host;
        }
    }

    @Then("I want to test against {string} as {string}")
    public void goToHostAs(String host, String username) {
        synchronized (Generic.class) {
            goToHost(host);
            Generic.user = username;
            Generic.password = USER_PASS.getProperty(username);
        }
    }

    @Then("I want to test against {string} as {string} with password {string}")
    public void goToHostAs(String host, String username, String password) {
        synchronized (Generic.class) {
            goToHostAs(host, username);
            Generic.password = password;
        }
    }

    @Then("^I want to use user \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void setCredentialsToUse(String user, String password) {
        synchronized (Generic.class) {
            Generic.user = user;
            Generic.password = password;
        }
    }

    @Then("I want to use default timeout {int} seconds for each operation")
    public void setTimeoutToUse(int timeoutInSeconds) {
        Configuration.timeout = timeoutInSeconds * 1000L;
    }

    @Then("Idam login if required for {string} as user and {string} as password and {string}")
    public void login(String userId, String passId, String submit) {
        open(host);
        if (!WebDriverRunner.url().startsWith(host)) {
            setValue(By.id(userId), user, SelenideElement::setValue);
            setValue(By.id(passId), password, SelenideElement::setValue);
            click(By.id(submit), SelenideElement::click);
        }
    }

    @Then("^enter \"([^\"]*)\" into \"([^\"]*)\"$")
    public void enterValue2ElementWithId(String value, String id) {
        $(By.id(id)).shouldBe(visible).setValue(value).pressEnter();
    }

    @Then("^close$")
    public void close() {
        closeWebDriver();
    }

    private static void click(By by, Consumer<SelenideElement> consumer) {
        SelenideElement userIdField = $(by);
        if (userIdField.waitUntil(Condition.visible, 1000 * 10).exists()) {
            consumer.accept(userIdField);
        }
    }

    private static boolean setValue(By by, String value, BiConsumer<SelenideElement, String> consumer) {
        SelenideElement userIdField = $(by);
        if (userIdField.shouldBe(Condition.visible).exists()) {
            consumer.accept(userIdField, value);
            return true;
        }
        return false;
    }

}
