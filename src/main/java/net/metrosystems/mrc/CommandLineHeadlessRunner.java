package net.metrosystems.mrc;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.cucumber.core.cli.Main;

public final class CommandLineHeadlessRunner {
    private CommandLineHeadlessRunner() {
    }

    public static void main(String[] args) {
        System.setProperty("selenide.headless", "true");
        Configuration.headless = true;
        Configuration.browser = Browsers.CHROME;
        Configuration.baseUrl = "http://" + System.getenv("DRP_CF_KUBERNETES_NAMESPACE")
            + "-" + System.getenv("DRP_CF_SERVICE") + "." + System.getenv("DRP_CF_INGRESS_HOST");
        Main.main(args);
    }
}
