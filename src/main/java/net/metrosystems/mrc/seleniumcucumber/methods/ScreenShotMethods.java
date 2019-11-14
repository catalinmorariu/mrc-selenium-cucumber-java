package net.metrosystems.mrc.seleniumcucumber.methods;

import net.metrosystems.mrc.env.DriverUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ScreenShotMethods {
    protected WebDriver driver = DriverUtil.getDefaultDriver();

    /**
     * Method to take screen shot and save in ./Screenshots folder
     */
    public void takeScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ROOT);
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        String scrFilepath = scrFile.getAbsolutePath();
        System.out.println("scrFilepath: " + scrFilepath);

        File currentDirFile = new File("Screenshots");
        String path = currentDirFile.getAbsolutePath();
        System.out.println("path: " + path + "+++");

        System.out.println("****\n" + path + "\\screenshot" + dateFormat.format(cal.getTime()) + ".png");

        Files.copy(scrFile.toPath(), Paths.get(path, "screenshot" + dateFormat.format(cal.getTime()) + ".png"));
    }
}
