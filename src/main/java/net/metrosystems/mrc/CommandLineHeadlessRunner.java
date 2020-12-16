package net.metrosystems.mrc;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.cucumber.core.cli.Main;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

public final class CommandLineHeadlessRunner {
    private static final Logger LOG = LoggerFactory.getLogger(CommandLineHeadlessRunner.class);
    private CommandLineHeadlessRunner() {
    }

    public static void main(String[] args) {
        prepareForCommandLineStart();

        var args4Cucumber = new ArrayList<String>();
        args4Cucumber.add("--glue");
        args4Cucumber.add("net.metrosystems.mrc.stepdefinitions");
        args4Cucumber.addAll(Arrays.asList(args));
        LOG.info("args {}", args4Cucumber);
        Main.main(args4Cucumber.toArray(new String[0]));
    }

    private static void prepareForCommandLineStart() {
        System.setProperty("selenide.headless", "true");
        Configuration.headless = true;
        Configuration.browser = Browsers.CHROME;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--headless",
            "--no-sandbox", "disable-infobars", "--disable-extensions",
            "--disable-gpu", "--disable-dev-shm-usage");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "http://" + System.getenv("DRP_CF_KUBERNETES_NAMESPACE")
            + "-" + System.getenv("DRP_CF_SERVICE") + "." + System.getenv("DRP_CF_INGRESS_HOST");
    }
}
