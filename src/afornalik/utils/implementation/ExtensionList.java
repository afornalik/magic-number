package afornalik.utils.implementation;

public enum ExtensionList {

    GIF(new String[]{"GIF89a", "GIF87a"}),
    JPG(new String[]{"JFIF", "Exif"}),
    TXT(new String[]{"^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$"}),
    BMP(new String[]{"BM"}),
    PDF(new String[]{"PDF"});


    private String[] signature;

    ExtensionList(String[] signature) {
        this.signature = signature;
    }

    public String[] getSignature() {
        return signature;
    }
}
