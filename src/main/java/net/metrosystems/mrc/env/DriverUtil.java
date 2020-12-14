package net.metrosystems.mrc.env;

import java.nio.file.Paths;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
                    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                    System.setProperty("webdriver.gecko.driver", Paths.get("drivers", "geckodriver-custom").toString());
                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    capabilities.setJavascriptEnabled(true);
                    capabilities.setCapability("takesScreenshot", true);
                    final WebDriver chosenDriver = chooseDriver(capabilities);
                    chosenDriver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                        TimeUnit.SECONDS);
                    chosenDriver.manage().window().maximize();
                    driver = chosenDriver;
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
     * @param capabilities
     * @return
     */
    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
        String preferredDriver = System.getProperty("browser", "chrome");
        boolean headless = "true".equals(System.getProperty("Headless", "true"));

        if ("chrome".equals(preferredDriver.toLowerCase(Locale.ROOT))) {
            final ChromeOptions chromeOptions = new ChromeOptions();
            if (headless) {
                chromeOptions.addArguments("--headless");
            }
            chromeOptions.addArguments("--no-sandbox"); //needed to run as root on ubuntu server
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-default-apps");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            System.out.println("********************* before driver created");
            ChromeDriver driver = new ChromeDriver(chromeOptions);
            System.out.println("********************* after driver created");
            ErrorHandler handler = new ErrorHandler();
            handler.setIncludeServerErrors(false);
            driver.setErrorHandler(handler);
            return driver;
            /*case "phantomjs":
                return new PhantomJSDriver(capabilities);*/
        }
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless", "-safe-mode");
        }
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return new FirefoxDriver();
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
                        driver.quit(); // fails in current geckodriver! TODO: Fixme
                    } catch (NoSuchMethodError | NoSuchSessionException | SessionNotCreatedException ignored) {
                    } // in case close fails
                    driver = null;
                }
            }
        }
    }
}
