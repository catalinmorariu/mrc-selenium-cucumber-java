package net.metrosystems.mrc.seleniumcucumber.methods;

import java.util.Arrays;

public class MiscMethods {
    public boolean validLocatorType(String type) {
        return Arrays.asList("id", "class", "css", "name", "xpath").contains(type);
    }

    /**
     * Method to verify locator type
     *
     * @param type : String : Locator type (id, name, class, xpath, css)
     */
    public void validateLocator(String type) {
        if (!validLocatorType(type)) {
            throw new RuntimeException("Invalid locator type - " + type);
        }
    }

    // method to validate dropdown selector
    public boolean validOptionBy(String optionBy) {
        return Arrays.asList("text", "value", "index").contains(optionBy);
    }

    /**
     * Method to verify dropdown selector (text, value or index)
     *
     * @param optionBy : String : Locator type (text, value, index)
     */
    public void validateOptionBy(String optionBy) {
        if (!validOptionBy(optionBy)) {
            throw new RuntimeException("Invalid option by - " + optionBy);
        }
    }
}
