package net.metrosystems.mrc.env;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public final class Env {
    private static WebDriver driver;
    private static String browserName;
    private static String cloudBrowserConfigFile;
    private static String cloudPlatformConfigFile;
    private static String currentPath = System.getProperty("user.dir");
    private static final Properties PROPERTIES = new Properties();

    private Env() {
    }

    public static String getBrowserName() {
        browserName = System.getProperty("browser");
        cloudBrowserConfigFile = System.getProperty("cloud_config");

        if (cloudBrowserConfigFile != null) {
            System.out.println("reading config file");
            try (InputStream ignored = Files.newInputStream(Paths.get(currentPath, "src", "main", "java", "cloudBrowserConfigs", cloudBrowserConfigFile + ".properties"))) {
                browserName = cloudBrowserConfigFile.split("_")[0];
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (browserName == null) {
            browserName = "ff";
        }
        return browserName;
    }

    public static WebDriver saucelabDriver() {
        System.out.println("Creating Saucelab Driver");
        HashMap<String, String> saucelabConfig = new HashMap<>();
        Enumeration enuKeys = PROPERTIES.keys();
        try {
            try (InputStream input = Files.newInputStream(Paths.get(currentPath, "src", "main", "java", "cloudPlatformConfigs", "saucelab.properties"))) {
                PROPERTIES.load(input);
                while (enuKeys.hasMoreElements()) {
                    String key = (String) enuKeys.nextElement();
                    String value = PROPERTIES.getProperty(key);
                    saucelabConfig.put(key, value);
                }
            }
            PROPERTIES.clear();

            String url = saucelabConfig.get("protocol") +
                "://" +
                saucelabConfig.get("username") +
                ":" +
                saucelabConfig.get("access_key") +
                saucelabConfig.get("url");

            System.out.println("url :" + url);
            URL remoteDriverURL = new URL(url);

            DesiredCapabilities capability = new DesiredCapabilities();
            try (InputStream input = Files.newInputStream(Paths.get(currentPath, "src", "main", "java", "cloudBrowserConfigs", cloudBrowserConfigFile + ".properties"))) {
                PROPERTIES.load(input);
                enuKeys = PROPERTIES.keys();
                while (enuKeys.hasMoreElements()) {
                    String key = (String) enuKeys.nextElement();
                    String value = PROPERTIES.getProperty(key);
                    System.out.println("key :" + key + " Value :" + value);
                    capability.setCapability(key, value);
                }
            }
            driver = new RemoteWebDriver(remoteDriverURL, capability);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return driver;
    }

    public static WebDriver createWebDriver(String browser) {
        System.out.println("Browser: " + browser);

        switch (browser.toLowerCase(Locale.ROOT)) {
            case "ff":
            case "firefox":
                //ProfilesIni allProfiles = new ProfilesIni();
                //FirefoxProfile profile = allProfiles.getProfile("selenium");
                //driver = new FirefoxDriver(profile);
                driver = new FirefoxDriver();
                break;

            case "ch":
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "ie":
            case "internetexplorer":
                driver = new InternetExplorerDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "saucelab":
                driver = saucelabDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name " + browser);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
}
