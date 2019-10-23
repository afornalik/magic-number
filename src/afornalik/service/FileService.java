package afornalik.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileService implements IFileService{

    private final File file;

    public FileService(File file) {
        this.file = file;
    }

    @Override
    public byte[] returnFirstByteFromFile() {
        byte[] firstByteFromFile = new byte[15];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(firstByteFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstByteFromFile;
    }
}
