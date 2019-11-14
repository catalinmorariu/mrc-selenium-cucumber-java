package net.metrosystems.mrc.seleniumcucumber.methods;

import net.metrosystems.mrc.env.DriverUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ConfigurationMethods {
    protected WebDriver driver;

    public ConfigurationMethods() {
        driver = DriverUtil.getDefaultDriver();
    }

    /**
     * Method to print desktop configuration
     */
    public void printDesktopConfiguration() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss", Locale.ROOT);
        Calendar cal = Calendar.getInstance();

        System.out.println("Following are machine configurations : \n");
        System.out.println("Date (MM/DD/YYYY) and Time (HH:MM:SS) : " + dateFormat.format(cal.getTime()));

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        System.out.println("Browser : " + cap.getBrowserName());
        System.out.println("Platform : " + cap.getPlatform());
    }
}
