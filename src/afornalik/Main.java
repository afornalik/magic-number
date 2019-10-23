package afornalik;

import afornalik.utils.exception.ExtensionNotSupportedException;
import afornalik.utils.implementation.ExtensionList;
import afornalik.utils.FileExtension;
import afornalik.utils.implementation.FileExtensionImpl;
import afornalik.utils.implementation.TextFileExtensionImpl;
import afornalik.service.FileService;
import afornalik.service.IFileService;

import java.io.*;

public class Main {


    private final static String CURRENT_PATH = System.getProperty("user.dir");

    private final static String SAMPLE_FILE = "task1.pdf"; //Insert file name here


    public static void main(String[] args) {


        File file = new File(CURRENT_PATH + "\\samples\\" + SAMPLE_FILE);
        IFileService fileService = new FileService(file);

        String inputFileExtension = fileService.returnInputFileExtension();

        byte[] firstBytesFromFile = fileService.returnFirstByteFromFile();

        FileExtension jpegExtension = new FileExtensionImpl(firstBytesFromFile, inputFileExtension, ExtensionList.JPG);
        FileExtension gifExtension = new FileExtensionImpl(firstBytesFromFile, inputFileExtension, ExtensionList.GIF);
        FileExtension txtExtension = new TextFileExtensionImpl(firstBytesFromFile, inputFileExtension, ExtensionList.TXT);
        FileExtension bmpExtension = new FileExtensionImpl(firstBytesFromFile, inputFileExtension, ExtensionList.BMP);
        FileExtension pdfExtension = new FileExtensionImpl(firstBytesFromFile, inputFileExtension, ExtensionList.PDF);

        jpegExtension.setNextChain(gifExtension);
        gifExtension.setNextChain(txtExtension);
        txtExtension.setNextChain(bmpExtension);
        bmpExtension.setNextChain(pdfExtension);

        try {
            jpegExtension.checkTheExtension();
        } catch (ExtensionNotSupportedException extensionNotSupportedException) {
            System.err.println(extensionNotSupportedException.getMessage());
        }


    }
}
