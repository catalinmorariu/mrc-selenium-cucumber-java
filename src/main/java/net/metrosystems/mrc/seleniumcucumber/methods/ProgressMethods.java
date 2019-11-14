package net.metrosystems.mrc.seleniumcucumber.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProgressMethods extends SelectElementByType {
    /**
     * Method to wait
     *
     * @param time : String : Time to wait
     * @throws NumberFormatException
     * @throws InterruptedException
     */
    public void wait(String time) throws InterruptedException {
        //sleep method takes parameter in milliseconds
        Thread.sleep(Integer.parseInt(time) * 1000);
    }

    /**
     * Method to Explicitly wait for element to be displayed
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @param duration   : String : Time to wait for element to be displayed
     */
    public void waitForElementToDisplay(String accessType, String accessName, String duration) {
        By byEle = getElementByType(accessType, accessName);
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(duration) * 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
    }

    /**
     * Method to Explicitly wait for element to be enabled=click
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @param duration   : String : Time to wait for element to be clickable
     */
    public void waitForElementToClick(String accessType, String accessName, String duration) {
        By byEle = getElementByType(accessType, accessName);
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(duration) * 1000);
        wait.until(ExpectedConditions.elementToBeClickable(byEle));
    }

    /**
     * Method to Explicitly wait for page loading
     *
     * @param duration   : String : Time to wait for page loading
     */
    public void waitForPageToLoad(int duration) {
        new WebDriverWait(driver, duration).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
}
