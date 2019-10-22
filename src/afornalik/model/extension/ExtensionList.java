package afornalik.model.extension;

public enum ExtensionList {

    GIF("GIF89a"),
    JPEG("JFIF");

    private String signature;

    ExtensionList(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }
}
