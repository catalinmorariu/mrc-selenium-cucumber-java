package net.metrosystems.mrc.seleniumcucumber.stepdefinitions;

import net.metrosystems.mrc.env.DriverUtil;
import net.metrosystems.mrc.seleniumcucumber.methods.TestCaseFailed;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.ASSERTION_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.CLICK_ELEMENTS_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.CONFIGURATION_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.INPUT_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.JAVASCRIPT_HANDLING_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.MISC_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.NAVIGATE_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.PROGRESS_METHODS;
import static net.metrosystems.mrc.seleniumcucumber.methods.BaseTest.SCREEN_SHOT_METHODS;

public final class PredefinedStepDefinitions {
    private WebDriver driver = DriverUtil.getDefaultDriver();

    //Navigation Steps

    //Step to navigate to specified URL
    @Then("^I navigate to \"([^\"]*)\"$")
    public void navigateTo(String link) {
        NAVIGATE_METHODS.navigateTo(link);
    }

    //Step to navigate forward
    @Then("^I navigate forward")
    public void navigateForward() {
        NAVIGATE_METHODS.navigate("forward");
    }

    //Step to navigate backward
    @Then("^I navigate back")
    public void navigateBack() {
        NAVIGATE_METHODS.navigate("back");
    }

    // steps to refresh page
    @Then("^I refresh page$")
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Switch between windows

    //Switch to new window
    @Then("^I switch to new window$")
    public void switchToNewWindow() {
        NAVIGATE_METHODS.switchToNewWindow();
    }

    //Switch to old window
    @Then("^I switch to previous window$")
    public void switchToOldWindow() {
        NAVIGATE_METHODS.switchToOldWindow();
    }

    //Switch to new window by window title
    @Then("^I switch to window having title \"(.*?)\"$")
    public void switchToWindowByTitle(String windowTitle) {
        NAVIGATE_METHODS.switchToWindowByTitle(windowTitle);
    }

    //Close new window
    @Then("^I close new window$")
    public void closeNewWindow() {
        NAVIGATE_METHODS.closeNewWindow();
    }

    // Switch between frame

    // Step to switch to frame by web element
    @Then("^I switch to frame having (.+) \"(.*?)\"$")
    public void switchFrameByElement(String method, String value) {
        NAVIGATE_METHODS.switchFrame(method, value);
    }

    // step to switch to main content
    @Then("^I switch to main content$")
    public void switchToDefaultContent() {
        NAVIGATE_METHODS.switchToDefaultContent();
    }

    // To interact with browser

    // step to resize browser
    @Then("^I resize browser window size to width (\\d+) and height (\\d+)$")
    public void resizeBrowser(int width, int heigth) {
        NAVIGATE_METHODS.resizeBrowser(width, heigth);
    }

    // step to maximize browser
    @Then("^I maximize browser window$")
    public void maximizeBrowser() {
        NAVIGATE_METHODS.maximizeBrowser();
    }

    //Step to close the browser
    @Then("^I close browser$")
    public void closeBrowser() {
        NAVIGATE_METHODS.closeDriver();
    }

    // zoom in/out page

    // steps to zoom in page
    @Then("^I zoom in page$")
    public void zoomIn() {
        NAVIGATE_METHODS.zoomInOut("ADD");
    }

    // steps to zoom out page
    @Then("^I zoom out page$")
    public void zoomOut() {
        NAVIGATE_METHODS.zoomInOut("SUBTRACT");
    }

    // zoom out webpage till necessary element displays

    // steps to zoom out till element displays
    @Then("^I zoom out page till I see element having (.+) \"(.*?)\"$")
    public void zoomTillElementDisplay(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        NAVIGATE_METHODS.zoomInOutTillElementDisplay(type, "substract", accessName);
    }

    // reset webpage view use

    @Then("^I reset page view$")
    public void resetPageZoom() {
        NAVIGATE_METHODS.zoomInOut("reset");
    }

    // scroll webpage

    @Then("^I scroll to (top|end) of page$")
    public void scrollPage(String to) {
        NAVIGATE_METHODS.scrollPage(to);
    }


    // scroll webpage to specific element

    @Then("^I scroll to element having (.+) \"(.*?)\"$")
    public void scrollToElement(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        NAVIGATE_METHODS.scrollToElement(type, accessName);
    }

    // hover over element

    // Note: Doesn't work on Windows firefox
    @Then("^I hover over element having (.+) \"(.*?)\"$")
    public void hoverOverElement(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        NAVIGATE_METHODS.hoverOverElement(type, accessName);
    }

    //Assertion steps

    /**
     * page title checking
     *
     * @param present :
     * @param title   :
     */
    @Then("^I should\\s*((?:not)?)\\s+see page title as \"(.+)\"$")
    public void checkTitle(String present, String title) throws TestCaseFailed {
        //System.out.println("Present :" + present.isEmpty());
        ASSERTION_METHODS.checkTitle(title, present.isEmpty());
    }

    // step to check element partial text
    @Then("^I should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
    public void checkPartialText(String present, String partialTextTitle) throws TestCaseFailed {
        //System.out.println("Present :" + present.isEmpty());
        ASSERTION_METHODS.checkPartialTitle(partialTextTitle, present.isEmpty());
    }

    // step to check element text
    @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
    public void checkElementText(String type, String accessName, String present, String value) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        ASSERTION_METHODS.checkElementText(type, value, accessName, present.isEmpty());
    }

    //step to check element partial text
    @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
    public void checkElementPartialText(String type, String accessName, String present, String value) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        ASSERTION_METHODS.checkElementPartialText(type, value, accessName, present.isEmpty());
    }

    // step to check attribute value
    @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$")
    public void checkElementAttribute(String type, String accessName, String present, String attrb, String value) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        ASSERTION_METHODS.checkElementsAttribute(type, attrb, value, accessName, present.isEmpty());
    }

    // step to check element enabled or not
    @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
    public void checkElementEnable(String type, String accessName, String present, String state) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        boolean flag = "enabled".equals(state);
        if (!present.isEmpty()) {
            flag = !flag;
        }
        ASSERTION_METHODS.checkElementEnable(type, accessName, flag);
    }

    //step to assert checkbox is checked or unchecked
    @Then("^checkbox having (.+) \"(.*?)\" should be (checked|unchecked)$")
    public void isCheckboxChecked(String type, String accessName, String state) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        boolean flag = "checked".equals(state);
        ASSERTION_METHODS.isCheckboxChecked(type, accessName, flag);
    }

    //steps to assert radio button checked or unchecked
    @Then("^radio button having (.+) \"(.*?)\" should be (selected|unselected)$")
    public void isRadioButtonSelected(String type, String accessName, String state) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        boolean flag = "selected".equals(state);
        ASSERTION_METHODS.isRadioButtonSelected(type, accessName, flag);
    }

    //steps to assert option by text from radio button group selected/unselected
    @Then("^option \"(.*?)\" by (.+) from radio button group having (.+) \"(.*?)\" should be (selected|unselected)$")
    public void isOptionFromRadioButtonGroupSelected(String option, String attrb, String type, String accessName, String state) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        boolean flag = "selected".equals(state);
        ASSERTION_METHODS.isOptionFromRadioButtonGroupSelected(type, attrb, option, accessName, flag);
    }

    //steps to check link presence
    @Then("^link having text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
    public void checkElementPresence(String accessName, String present) throws TestCaseFailed {
        ASSERTION_METHODS.checkElementPresence("linkText", accessName, present.isEmpty());
    }

    //step to check element present or not
    @Then("^element having (.+) \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
    public void checkElementPresence(String type, String accessName, String present) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        ASSERTION_METHODS.checkElementPresence(type, accessName, present.isEmpty());
    }

    //steps to check partail link presence
    @Then("^link having partial text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
    public void checkPartialElementPresence(String accessName, String present) throws TestCaseFailed {
        ASSERTION_METHODS.checkElementPresence("partialLinkText", accessName, present.isEmpty());
    }

    //step to assert javascript pop-up alert text
    @Then("^I should see alert text as \"(.*?)\"$")
    public void checkAlertText(String actualValue) throws TestCaseFailed {
        ASSERTION_METHODS.checkAlertText(actualValue);
    }

    // step to select dropdown list
    @Then("^option \"(.*?)\" by (.+) from dropdown having (.+) \"(.*?)\" should be (selected|unselected)$")
    public void isOptionFromDropdownSelected(String option, String by, String type, String accessName, String state) throws TestCaseFailed {
        MISC_METHODS.validateLocator(type);
        boolean flag = "selected".equals(state);
        ASSERTION_METHODS.isOptionFromDropdownSelected(type, by, option, accessName, flag);
    }

    //Input steps

    // enter text into input field steps
    @Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
    public void enterText(String text, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.enterText(type, text, accessName);
    }

    // clear input field steps
    @Then("^I clear input field having (.+) \"([^\"]*)\"$")
    public void clearText(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.clearText(type, accessName);
    }

    // select option by text/value from dropdown
    @Then("^I select \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
    public void selectOptionFromDropdown(String option, String optionBy, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        MISC_METHODS.validateOptionBy(optionBy);
        INPUT_METHODS.selectOptionFromDropdown(type, optionBy, option, accessName);
    }

    // select option by index from dropdown
    @Then("^I select (\\d+) option by index from dropdown having (.+) \"(.*?)\"$")
    public void selectOptionFromDropdownByIndex(String option, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.selectOptionFromDropdown(type, "selectByIndex", option, accessName);
    }

    // select option by text/value from multiselect
    @Then("^I select \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
    public void selectOptionFromMultiSelectDropdown(String option, String optionBy, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        MISC_METHODS.validateOptionBy(optionBy);
        INPUT_METHODS.selectOptionFromDropdown(type, optionBy, option, accessName);
    }

    // select option by index from multiselect
    @Then("^I select (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
    public void selectOptionFromMultiSelectDropdownByIndex(String option, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.selectOptionFromDropdown(type, "selectByIndex", option, accessName);
    }

    // deselect option by text/value from multiselect
    @Then("^I deselect \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
    public void deselectOptionFromMultiSelectDropdown(String option, String optionBy, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        MISC_METHODS.validateOptionBy(optionBy);
        INPUT_METHODS.deselectOptionFromDropdown(type, optionBy, option, accessName);
    }

    // deselect option by index from multiselect
    @Then("^I deselect (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
    public void deselectOptionFromMultiSelectDropdownByIndex(String option, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.deselectOptionFromDropdown(type, "selectByIndex", option, accessName);
    }

    // step to unselect option from mutliselect dropdown list
    @Then("^I deselect all options from multiselect dropdown having (.+) \"(.*?)\"$")
    public void unselectAllOptionFromMultiselectDropdown(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.unselectAllOptionFromMultiselectDropdown(type, accessName);
    }

    //check checkbox steps
    @Then("^I check the checkbox having (.+) \"(.*?)\"$")
    public void checkCheckbox(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.checkCheckbox(type, accessName);
    }

    //uncheck checkbox steps
    @Then("^I uncheck the checkbox having (.+) \"(.*?)\"$")
    public void uncheckCheckbox(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.uncheckCheckbox(type, accessName);
    }

    //steps to toggle checkbox
    @Then("^I toggle checkbox having (.+) \"(.*?)\"$")
    public void toggleCheckbox(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.toggleCheckbox(type, accessName);
    }

    // step to select radio button
    @Then("^I select radio button having (.+) \"(.*?)\"$")
    public void selectRadioButton(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        INPUT_METHODS.selectRadioButton(type, accessName);
    }

    // steps to select option by text from radio button group
    @Then("^I select \"(.*?)\" option by (.+) from radio button group having (.+) \"(.*?)\"$")
    public void selectOptionFromRadioBtnGroup(String option, String by, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        //miscmethodObj.validateOptionBy(optionBy);
        INPUT_METHODS.selectOptionFromRadioButtonGroup(type, option, by, accessName);
    }

    //Click element Steps

    // click on web element
    @Then("^I click on element having (.+) \"(.*?)\"$")
    public void click(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        CLICK_ELEMENTS_METHODS.click(type, accessName);
    }

    //Forcefully click on element
    @Then("^I forcefully click on element having (.+) \"(.*?)\"$")
    public void clickForcefully(String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        CLICK_ELEMENTS_METHODS.clickForcefully(type, accessName);
    }

    // double click on web element
    @Then("^I double click on element having (.+) \"(.*?)\"$")
    public void doubleClick(String type, String accessValue) {
        MISC_METHODS.validateLocator(type);
        CLICK_ELEMENTS_METHODS.doubleClick(type, accessValue);
    }

    // steps to click on link
    @Then("^I click on link having text \"(.*?)\"$")
    public void clickLink(String accessName) {
        CLICK_ELEMENTS_METHODS.click("linkText", accessName);
    }

    //Step to click on partial link
    @Then("^I click on link having partial text \"(.*?)\"$")
    public void clickPartialLink(String accessName) {
        CLICK_ELEMENTS_METHODS.click("partialLinkText", accessName);
    }

    //Progress methods

    // wait for specific period of time
    @Then("^I wait for (\\d+) sec$")
    public void wait(String time) throws InterruptedException {
        PROGRESS_METHODS.wait(time);
    }

    //wait for specific element to display for specific period of time
    @Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to display$")
    public void waitForElementToDisplay(String duration, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        PROGRESS_METHODS.waitForElementToDisplay(type, accessName, duration);
    }

    // wait for specific element to enable for specific period of time
    @Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to be enabled$")
    public void waitForElementToClick(String duration, String type, String accessName) {
        MISC_METHODS.validateLocator(type);
        PROGRESS_METHODS.waitForElementToClick(type, accessName, duration);
    }

    @Then("^I wait for page loading but no more than (\\d+) seconds")
    public void waitForPageToLoad(int duration) {
        PROGRESS_METHODS.waitForPageToLoad(duration);
    }

    //JavaScript handling steps

    //Step to handle java script
    @Then("^I accept alert$")
    public void handleAlert() {
        JAVASCRIPT_HANDLING_METHODS.handleAlert("accept");
    }

    //Steps to dismiss java script
    @Then("^I dismiss alert$")
    public void dismissAlert() {
        JAVASCRIPT_HANDLING_METHODS.handleAlert("dismiss");
    }

    //Screen shot methods

    @Then("^I take screenshot$")
    public void takeScreenshot() throws IOException {
        SCREEN_SHOT_METHODS.takeScreenShot();
    }

    //Configuration steps

    // step to print configuration
    @Then("^I print configuration$")
    public void printConfig() {
        CONFIGURATION_METHODS.printDesktopConfiguration();
    }

    @Then("^I'm able to find element")
    public void findElement() {

    }
    /*@After
    public final void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            try {
                ScenarioImpl impl = (ScenarioImpl) scenario;
                Collection<String> tags = impl.getSourceTagNames();
                String name = "Scenario";
                for (String t : tags) {
                    name += "_" + t;
                }

                String name = "Screenshots/" + impl.getId().replaceAll("\\W", "_");
                FileUtils.copyFile(srcFile, new File(name + ".png"));
            } catch (IOException ex) {
                //Logger.getLogger(SmapScenario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/

/*    @After
    public final void tearDown() {
        DriverUtil.closeDriver();
    }*/
}
