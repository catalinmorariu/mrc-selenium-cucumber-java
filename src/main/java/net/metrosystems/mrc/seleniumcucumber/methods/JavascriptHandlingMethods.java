package net.metrosystems.mrc.seleniumcucumber.methods;

import net.metrosystems.mrc.env.DriverUtil;
import org.openqa.selenium.WebDriver;

public class JavascriptHandlingMethods {
    protected WebDriver driver = DriverUtil.getDefaultDriver();

    /**
     * Method to handle alert
     *
     * @param decision : String : Accept or dismiss alert
     */
    public void handleAlert(String decision) {
        if ("accept".equals(decision)) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }
}
