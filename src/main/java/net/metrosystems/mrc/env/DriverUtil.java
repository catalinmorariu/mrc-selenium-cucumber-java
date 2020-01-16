package net.metrosystems.mrc.env;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by tom on 24/02/17.
 */
public final class DriverUtil {
    public static final long DEFAULT_WAIT = 20;
    private static volatile WebDriver driver;

    private DriverUtil() {
    }

    public static WebDriver getDefaultDriver() {
        if (driver == null) {
            synchronized (DriverUtil.class) {
                if (driver == null) {
                    //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                    //System.setProperty("webdriver.gecko.driver", Paths.get("drivers", "geckodriver-custom").toString());
                    System.setProperty("webdriver.chrome.driver", Paths.get("drivers", "chromedriver").toString());
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    final WebDriver chosenDriver = chooseDriver(chromeOptions);
                    chosenDriver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                        TimeUnit.SECONDS);
                    chosenDriver.manage().window().maximize();
                }
            }
        }
        return driver;
    }

    /**
     * By default to web driver will be PhantomJS
     * <p>
     * Override it by passing -DWebDriver=Chrome to the command line arguments
     *
     * @param chromeOptions2
     * @return
     */
    private static WebDriver chooseDriver(ChromeOptions chromeOptions2) {
        String preferredDriver = System.getProperty("browser", "chrome");
        boolean headless = System.getProperty("Headless", "true").equals("true");

        if ("chrome".equals(preferredDriver.toLowerCase(Locale.ROOT))) {
            final ChromeOptions chromeOptions = new ChromeOptions();
            if (headless) {
                chromeOptions.addArguments("--headless");
            }
           // chromeOptions2.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            System.out.println("********************* before driver created");
            ChromeDriver driver = new ChromeDriver();
            System.out.println("********************* after driver created");
            ErrorHandler handler = new ErrorHandler();
            handler.setIncludeServerErrors(false);
            driver.setErrorHandler(handler);
            return driver;
            /*case "phantomjs":
                return new PhantomJSDriver(capabilities);*/
        } else {
        FirefoxOptions options = new FirefoxOptions();
     //   chromeOptions2.setCapability(preferredDriver, headless);
        if (headless) {
            options.setHeadless(true);
        }
     //   chromeOptions2.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return new FirefoxDriver();
    }
    }


    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector,
                                                            int seconds) {
        By selection = By.cssSelector(selector);
        return new WebDriverWait(driver, seconds).until(
            // ensure element is visible!
            ExpectedConditions.visibilityOfElementLocated(selection));
    }

    public static void closeDriver() {
        if (driver != null) {
            synchronized (DriverUtil.class) {
                if (driver != null) {
                    try {
                        driver.close();
                        driver.quit();
                    } catch (NoSuchMethodError | NoSuchSessionException | SessionNotCreatedException ignored) {
                    } // in case close fails
                    driver = null;
                }
            }
        }
    }
}
