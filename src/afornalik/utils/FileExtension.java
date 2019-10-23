package afornalik.utils;

import afornalik.utils.implementation.ExtensionList;

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

    protected String getFILE_EXTENSION() {
        return FILE_EXTENSION;
    }

    protected String[] getEXPECTED_EXTENSION() {
        return EXPECTED_EXTENSION;
    }

    protected byte[] getFirstByteFromFile() {
        return firstByteFromFile;
    }

    protected String getInputFileExtension() {
        return inputFileExtension;
    }
}
