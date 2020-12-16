package net.metrosystems.mrc;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.cucumber.core.cli.Main;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class CommandLineHeadlessRunner {
    private CommandLineHeadlessRunner() {
    }

    public static void main(String[] args) {
        System.setProperty("selenide.headless", "true");
        Configuration.headless = true;
        Configuration.browser = Browsers.CHROME;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "http://" + System.getenv("DRP_CF_KUBERNETES_NAMESPACE")
            + "-" + System.getenv("DRP_CF_SERVICE") + "." + System.getenv("DRP_CF_INGRESS_HOST");
        Main.main(args);
    }
}
