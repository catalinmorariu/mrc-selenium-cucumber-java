package net.metrosystems.tests.stepdefintions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class Hooks {
    @After("@NegativeTest")
    public void beforeScenario(Scenario scenario) {
//      System.out.println("In hooks");
//      System.out.println(scenario.getName());
//      System.out.println(scenario.getStatus());
    }
}
