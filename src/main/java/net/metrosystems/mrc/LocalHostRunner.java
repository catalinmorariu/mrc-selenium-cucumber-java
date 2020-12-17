package net.metrosystems.mrc;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.cucumber.core.cli.Main;

public final class LocalHostRunner {
    private LocalHostRunner() {
    }

    public static void main(String[] args) {
        Configuration.browser = Browsers.CHROME;
        Configuration.holdBrowserOpen = true;
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        Main.main("features/");
    }
}
