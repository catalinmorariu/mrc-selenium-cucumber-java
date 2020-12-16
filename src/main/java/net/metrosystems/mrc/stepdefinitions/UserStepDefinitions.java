package net.metrosystems.mrc.stepdefinitions;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class UserStepDefinitions {
    private static volatile String host;
    private static volatile String user;
    private static volatile String password;
    private static final Properties USER_PASS = new Properties();

    //Prerequisite Steps
    static {
        try (InputStream iStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("users.properties")) {
            // Loading properties file from the path (relative path given here)
            USER_PASS.load(iStream);
            Configuration.headless = true;
            WebDriverManager.chromedriver().browserPath("drivers/chromedriver");
            Configuration.baseUrl = "http://" + System.getenv("DRP_CF_KUBERNETES_NAMESPACE")
                + "-" + System.getenv("DRP_CF_SERVICE") + "." + System.getenv("DRP_CF_INGRESS_HOST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("^I want to test against \"([^\"]*)\"$")
    public void goToHost(String host) {
        synchronized (UserStepDefinitions.class) {
            UserStepDefinitions.host = host;
        }
    }

    @Then("^I want to test against \"([^\"]*)\" as \"([^\"]*)\"$")
    public void goToHostAs(String host, String username) {
        synchronized (UserStepDefinitions.class) {
            goToHost(host);
            UserStepDefinitions.user = username;
            UserStepDefinitions.password = USER_PASS.getProperty(username);
        }
    }

    @Then("^I want to test against \"([^\"]*)\" as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void goToHostAs(String host, String username, String password) {
        synchronized (UserStepDefinitions.class) {
            goToHostAs(host, username);
            UserStepDefinitions.password = password;
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
        Configuration.timeout = timeoutInSeconds * 1000L;
    }

    @Then("^Idam login if required for \"([^\"]*)\" as user and \"([^\"]*)\" as password and \"([^\"]*)\"$")
    public void login(String userId, String passId, String submit) {
        Configuration.headless = false;

        open(host);
        if (!WebDriverRunner.url().startsWith(host)) {
            setValue(By.id(userId), user, SelenideElement::setValue);
            setValue(By.id(passId), password, SelenideElement::setValue);
            click(By.id(submit), SelenideElement::click);
        }
    }

    @Then("^go to \"([^\"]*)\" tile at launchpad$")
    public void gotToTile(String tileName) {
        String[] href = new String[1];
        $$(".mrc-tile")
            .shouldBe(CollectionCondition.anyMatch("reportTile",
                webElement -> {
                    href[0] = webElement.getAttribute("href");
                    return href[0] != null && href[0].endsWith(tileName);
                }));
        open(href[0]);

    }

    @Then("^close$")
    public void close() {
        closeWebDriver();
    }

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
