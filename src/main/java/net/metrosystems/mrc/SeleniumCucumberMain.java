package net.metrosystems.mrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings({"PMD.UseUtilityClass"})
@SpringBootApplication
public class SeleniumCucumberMain {
    public static void main(String[] args) {
        SpringApplication.run(SeleniumCucumberMain.class, args);
    }

   /* public static void main(String[] args) {
        Main.main(new String[] {
            "--glue",
            "net.metrosystems.mrc.seleniumcucumber.stepdefinitions",
            "features/"}
        );
    }*/
}
