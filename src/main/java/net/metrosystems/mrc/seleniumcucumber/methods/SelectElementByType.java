package net.metrosystems.mrc.seleniumcucumber.methods;

import net.metrosystems.mrc.env.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectElementByType {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public SelectElementByType() {
        driver = DriverUtil.getDefaultDriver();
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Method to select element 'by' type
     *
     * @param type       : String : 'By' type
     * @param accessName : String : Locator value
     * @return By
     */
    public By getElementByType(String type, String accessName) {
        switch (type) {
            case "id":
                return By.id(accessName);
            case "name":
                return By.name(accessName);
            case "class":
                return By.className(accessName);
            case "xpath":
                return By.xpath(accessName);
            case "css":
                return By.cssSelector(accessName);
            case "linkText":
                return By.linkText(accessName);
            case "partialLinkText":
                return By.partialLinkText(accessName);
            case "tagName":
                return By.tagName(accessName);
            default:
                return null;

        }
        /*if (type.equals("id")) {
            return By.id(accessName);
        } else if (type.equals("name")) {
            return By.name(accessName);
        } else if (type.equals("class")) {
            return By.className(accessName);
        } else if (type.equals("xpath")) {
            return By.xpath(accessName);
        } else if (type.equals("css")) {
            return By.cssSelector(accessName);
        } else if (type.equals("linkText")) {
            return By.linkText(accessName);
        } else if (type.equals("partialLinkText")) {
            return By.partialLinkText(accessName);
        } else if (type.equals("tagName")) {
            return By.tagName(accessName);
        } else {
            return null;
        }*/
    }
}
