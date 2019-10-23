package afornalik.model.exception;

public class ExtensionNotSupportedException extends Exception {
    private String message;

    public ExtensionNotSupportedException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
