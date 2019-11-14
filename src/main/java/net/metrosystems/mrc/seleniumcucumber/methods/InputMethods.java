package net.metrosystems.mrc.seleniumcucumber.methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class InputMethods extends SelectElementByType {
    //SelectElementByType eleType= new SelectElementByType();
    private WebElement dropdown;
    private Select selectList;

    /**
     * Method to enter text into text field
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param text       : String : Text value to enter in field
     * @param accessName : String : Locator value
     */
    public void enterText(String accessType, String text, String accessName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        driver.findElement(getElementByType(accessType, accessName)).sendKeys(text);
    }

    /**
     * Method to clear text of text field
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void clearText(String accessType, String accessName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        driver.findElement(getElementByType(accessType, accessName)).clear();
    }

    /**
     * Method to select element from Dropdown by type
     *
     * @param selectList : Select : Select variable
     * @param byType     : String : Name of by type
     * @param option     : String : Option to select
     */
    public void selectElementFromDropdownByType(Select selectList, String byType, String option) {
        if ("selectByIndex".equals(byType)) {
            int index = Integer.parseInt(option);
            selectList.selectByIndex(index - 1);
        } else if ("value".equals(byType)) {
            selectList.selectByValue(option);
        } else if ("text".equals(byType)) {
            selectList.selectByVisibleText(option);
        }
    }

    /**
     * Method to select option from dropdown list
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param optionBy   : String : Name of by type
     * @param option     : String : Option to select
     * @param accessName : String : Locator value
     */
    public void selectOptionFromDropdown(String accessType, String optionBy, String option, String accessName) {
        dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        selectList = new Select(dropdown);

        if ("selectByIndex".equals(optionBy)) {
            selectList.selectByIndex(Integer.parseInt(option) - 1);
        } else if ("value".equals(optionBy)) {
            selectList.selectByValue(option);
        } else if ("text".equals(optionBy)) {
            selectList.selectByVisibleText(option);
        }
    }

    /**
     * Method to unselect all option from dropdwon list
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void unselectAllOptionFromMultiselectDropdown(String accessType, String accessName) {
        dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        selectList = new Select(dropdown);
        selectList.deselectAll();
    }

    /**
     * Method to unselect option from dropdwon list
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void deselectOptionFromDropdown(String accessType, String optionBy, String option, String accessName) {
        dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        selectList = new Select(dropdown);

        if ("selectByIndex".equals(optionBy)) {
            selectList.deselectByIndex(Integer.parseInt(option) - 1);
        } else if ("value".equals(optionBy)) {
            selectList.deselectByValue(option);
        } else if ("text".equals(optionBy)) {
            selectList.deselectByVisibleText(option);
        }
    }

    /**
     * Method to check check-box
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void checkCheckbox(String accessType, String accessName) {
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * Method to uncheck check-box
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void uncheckCheckbox(String accessType, String accessName) {
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * Method to toggle check-box status
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void toggleCheckbox(String accessType, String accessName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName))).click();
    }

    /**
     * Method to select radio button
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void selectRadioButton(String accessType, String accessName) {
        WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    /**
     * Method to select option from radio button group
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param by         : String : Name of by type
     * @param option     : String : Option to select
     * @param accessName : String : Locator value
     */
    public void selectOptionFromRadioButtonGroup(String accessType, String option, String by, String accessName) {
        List<WebElement> radioButtonGroup = driver.findElements(getElementByType(accessType, accessName));
        for (WebElement rb : radioButtonGroup) {
            if ("value".equals(by) && rb.getAttribute("value").equals(option) && !rb.isSelected()) {
                rb.click();
            } else if ("text".equals(by) && rb.getText().equals(option) && !rb.isSelected()) {
                rb.click();
            }
        }
    }
}
