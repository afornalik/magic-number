package afornalik.model.implementation;

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
            System.out.println("Extension is : "+ super.getFILE_EXTENSION());
        } else {
            System.out.println("Extension is not : "+ super.getFILE_EXTENSION());
            this.nextChain.checkTheExtension();
        }
    }

    @Override
    public void setNextChain(FileExtension nextChain) {
        this.nextChain = nextChain;
    }
}
