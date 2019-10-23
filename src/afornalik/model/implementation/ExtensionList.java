package afornalik.model.implementation;

public enum ExtensionList {

    GIF("GIF89a"),
    JPEG("JFIF"),
    TXT("ASCII"),
    BMP("BM"),
    PDF("PDF");


    private String signature;

    ExtensionList(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }
}
