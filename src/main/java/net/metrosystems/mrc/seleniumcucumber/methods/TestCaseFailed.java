package net.metrosystems.mrc.seleniumcucumber.methods;

public class TestCaseFailed extends Exception {
    /**
     * Added serializable variable to remove warning
     */
    private static final long serialVersionUID = 1L;
    private String message;

    public TestCaseFailed() {
        super();
    }

    public TestCaseFailed(String message) {
        super(message);
        this.message = message;
    }

}
