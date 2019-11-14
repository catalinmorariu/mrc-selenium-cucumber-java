package net.metrosystems.mrc.seleniumcucumber.methods;

public final class BaseTest {
    public static final MiscMethods MISC_METHODS = new MiscMethods();
    public static final NavigateMethods NAVIGATE_METHODS = new NavigateMethods();
    public static final AssertionMethods ASSERTION_METHODS = new AssertionMethods();
    public static final ClickElementsMethods CLICK_ELEMENTS_METHODS = new ClickElementsMethods();
    public static final ConfigurationMethods CONFIGURATION_METHODS = new ConfigurationMethods();
    public static final InputMethods INPUT_METHODS = new InputMethods();
    public static final ProgressMethods PROGRESS_METHODS = new ProgressMethods();
    public static final JavascriptHandlingMethods JAVASCRIPT_HANDLING_METHODS = new JavascriptHandlingMethods();
    public static final ScreenShotMethods SCREEN_SHOT_METHODS = new ScreenShotMethods();

    private BaseTest() {
    }
}
