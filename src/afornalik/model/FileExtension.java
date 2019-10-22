package afornalik.model;

import afornalik.model.extension.ExtensionList;

import java.io.File;

public abstract class FileExtension implements Checkable {

    private final String FILE_EXTENSION;
    private final String EXPECTED_EXTENSION;
    private File file;

    public FileExtension(File file, ExtensionList extensionList) {
        this.file = file;
        FILE_EXTENSION = extensionList.name();
        EXPECTED_EXTENSION = extensionList.getSignature();
    }

    public String getFILE_EXTENSION() {
        return FILE_EXTENSION;
    }

    public String getEXPECTED_EXTENSION() {
        return EXPECTED_EXTENSION;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
