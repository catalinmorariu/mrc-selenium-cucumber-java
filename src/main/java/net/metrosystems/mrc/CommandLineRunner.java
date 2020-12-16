package net.metrosystems.mrc;

import com.codeborne.selenide.Configuration;
import io.cucumber.core.cli.Main;

public final class CommandLineRunner {
    private CommandLineRunner() {
    }

    public static void main(String[] args) {
        Configuration.browserBinary = "drivers/chromedriver";
        Main.main(args);
    }

}