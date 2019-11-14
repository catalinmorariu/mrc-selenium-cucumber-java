package net.metrosystems.mrc.seleniumcucumber.methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;


public class NavigateMethods extends SelectElementByType {
    private WebElement element;
    private String oldWin;
    private String lastWinHandle;

    /**
     * Method to open link
     *
     * @param url : String : URL for navigation
     */
    public void navigateTo(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to navigate back & forward
     *
     * @param direction : String : Navigate to forward or backward
     */
    public void navigate(String direction) {
        if ("back".equals(direction)) {
            driver.navigate().back();
        } else {
            driver.navigate().forward();
        }
    }

    /**
     * Method to quite webdriver instance
     */
    public void closeDriver() {
        driver.close();
    }

    /**
     * Method to return key by OS wise
     *
     * @return Keys : Return control or command key as per OS
     */
    public Keys getKey() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if ("win".contains(os)) {
            return Keys.CONTROL;
        } else if (os.contains("nux") || os.contains("nix")) {
            return Keys.CONTROL;
        } else if (os.contains("mac")) {
            return Keys.COMMAND;
        } else {
            return null;
        }
    }

    /**
     * Method to zoom in/out page
     *
     * @param inOut : String : Zoom in or out
     */
    public void zoomInOut(String inOut) {
        WebElement sel = driver.findElement(getElementByType("tagName", "html"));
        if ("ADD".equals(inOut)) {
            sel.sendKeys(Keys.chord(getKey(), Keys.ADD));
        } else if ("SUBTRACT".equals(inOut)) {
            sel.sendKeys(Keys.chord(getKey(), Keys.SUBTRACT));
        } else if ("reset".equals(inOut)) {
            sel.sendKeys(Keys.chord(getKey(), Keys.NUMPAD0));
        }
    }

    /**
     * Method to zoom in/out web page until web element displays
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param inOut      : String : Zoom in or out
     * @param accessName : String : Locator value
     */
    public void zoomInOutTillElementDisplay(String accessType, String inOut, String accessName) {
        Actions action = new Actions(driver);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        while (true) {
            if (element.isDisplayed()) {
                break;
            } else {
                action.keyDown(getKey()).sendKeys(inOut).keyUp(getKey()).perform();
            }
        }
    }

    /**
     * Method to resize browser
     *
     * @param width  : int : Width for browser resize
     * @param height : int : Height for browser resize
     */
    public void resizeBrowser(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    /**
     * Method to maximize browser
     */
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * Method to hover on element
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void hoverOverElement(String accessType, String accessName) {
        Actions action = new Actions(driver);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        action.moveToElement(element).perform();
    }

    /**
     * Method to scroll page to particular element
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void scrollToElement(String accessType, String accessName) {
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Method to scroll page to top or end
     *
     * @param to : String : Scroll page to Top or End
     */
    public void scrollPage(String to) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        if ("end".equals(to)) {
            executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        } else if ("top".equals(to)) {
            executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
        } else {
            throw new RuntimeException("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
        }
    }

    /**
     * Method to switch to new window
     */
    public void switchToNewWindow() {
        oldWin = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            lastWinHandle = winHandle;
        }
        driver.switchTo().window(lastWinHandle);
    }

    /**
     * Method to switch to old window
     */
    public void switchToOldWindow() {
        driver.switchTo().window(oldWin);
    }

    /**
     * Method to switch to window by title
     *
     * @param windowTitle : String : Name of window title to switch
     */
    public void switchToWindowByTitle(String windowTitle) {
        //System.out.println("++"+windowTitle+"++");
        oldWin = driver.getWindowHandle();
        boolean winFound = false;
        for (String winHandle : driver.getWindowHandles()) {
            String str = driver.switchTo().window(winHandle).getTitle();
            //System.out.println("**"+str+"**");
            if (str.equals(windowTitle)) {
                winFound = true;
                break;
            }
        }
        if (!winFound) {
            throw new RuntimeException("Window having title " + windowTitle + " not found");
        }
    }

    /**
     * Method to close new window
     */
    public void closeNewWindow() {
        driver.close();
    }

    /**
     * Method to switch frame using web element frame
     *
     * @param accessType : String : Locator type (index, id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void switchFrame(String accessType, String accessName) {
        if ("index".equalsIgnoreCase(accessType)) {
            driver.switchTo().frame(accessName);
        } else {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
            driver.switchTo().frame(element);
        }
    }

    /**
     * method to switch to default content
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
