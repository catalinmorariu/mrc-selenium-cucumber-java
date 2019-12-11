package net.metrosystems.mrc;

import io.cucumber.core.cli.Main;

public final class SeleniumCucumberMain {
    private SeleniumCucumberMain() {
    }

    public static void main(String[] args) {
        Main.main(new String[] {
            "--glue",
            "net.metrosystems.mrc.seleniumcucumber.stepdefinitions",
            "features/"}
        );
    }
}
