package afornalik.model;

import afornalik.model.implementation.ExtensionList;

public abstract class FileExtension implements Checkable {

    private final String FILE_EXTENSION;
    private final String[] EXPECTED_EXTENSION;
    private byte[] firstByteFromFile;
    private String inputFileExtension;

    public FileExtension(byte[] firstBytesFromFile, String inputFileExtension, ExtensionList extensionList) {
        this.firstByteFromFile = firstBytesFromFile;
        this.inputFileExtension = inputFileExtension;
        FILE_EXTENSION = extensionList.name();
        EXPECTED_EXTENSION = extensionList.getSignature();
    }

    public String getFILE_EXTENSION() {
        return FILE_EXTENSION;
    }

    public String[] getEXPECTED_EXTENSION() {
        return EXPECTED_EXTENSION;
    }

    public byte[] getFirstByteFromFile() {
        return firstByteFromFile;
    }

    public String getInputFileExtension() {
        return inputFileExtension;
    }
}
