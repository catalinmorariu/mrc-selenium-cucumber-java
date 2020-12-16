package net.metrosystems.mrc;

import com.codeborne.selenide.Configuration;
import io.cucumber.core.cli.Main;

public final class CommandLineHeadlessRunner {
    private CommandLineHeadlessRunner() {
    }

    public static void main(String[] args) {
        System.setProperty("selenide.headless", "true");
        Configuration.headless = true;
        Configuration.browserBinary = "drivers/chromedriver";
        Main.main(args);
    }
}
