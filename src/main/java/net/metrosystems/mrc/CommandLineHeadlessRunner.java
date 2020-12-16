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
        options.addArguments("--disable-extensions", "--headless",
            "--no-sandbox", "disable-infobars", "--disable-extensions",
            "--disable-gpu", "--disable-dev-shm-usage");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "http://" + System.getenv("DRP_CF_KUBERNETES_NAMESPACE")
            + "-" + System.getenv("DRP_CF_SERVICE") + "." + System.getenv("DRP_CF_INGRESS_HOST");
        Main.main(args);
    }
}
