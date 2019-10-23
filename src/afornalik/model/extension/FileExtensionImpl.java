package afornalik.model.extension;

import afornalik.model.FileExtension;


public class FileExtensionImpl extends FileExtension {

    private FileExtension nextChain;

    public FileExtensionImpl(byte[] firstBytesFromFile, ExtensionList extensionList) {
        super(firstBytesFromFile, extensionList);
    }

    @Override
    public void checkTheExtension() {
        StringBuilder firstStringFromFile = new StringBuilder();
        for (byte b : super.getFirstByteFromFile()) {
            firstStringFromFile.append((char) b);
        }
        if (firstStringFromFile.toString().contains(super.getEXPECTED_EXTENSION())) {
            System.out.println("true");
        } else {
            this.nextChain.checkTheExtension();
        }
        System.out.println(firstStringFromFile);
    }

    @Override
    public void setNextChain(FileExtension nextChain) {
        this.nextChain = nextChain;
    }
}
