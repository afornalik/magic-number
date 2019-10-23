package afornalik.model.implementation;

public enum ExtensionList {

    GIF(new String[]{"GIF89a", "GIF87a"}),
    JPG(new String[]{"JFIF", "Exif"}),
    TXT(new String[]{"ASCII"}),
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
