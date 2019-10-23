package afornalik;

import afornalik.model.exception.ExtensionNotSupportedException;
import afornalik.model.implementation.ExtensionList;
import afornalik.model.FileExtension;
import afornalik.model.implementation.FileExtensionImpl;
import afornalik.service.FileService;
import afornalik.service.IFileService;

import java.io.*;
import java.util.Scanner;

public class Main {


    private final static String CURRENT_PATH = System.getProperty("user.dir");

    private final static String SAMPLE_FILE = "task1.pdf"; //Insert file name here


    public static void main(String[] args) {

        //to do -  checking for .txt extension is not working.
        //I can not find ISO 8859-1 representation for this file.

        File file = new File(CURRENT_PATH+"\\samples\\"+SAMPLE_FILE);
        IFileService fileService = new FileService(file);

        String inputFileExtension = fileService.returnInputFileExtension();

        byte[] firstBytesFromFile = fileService.returnFirstByteFromFile();

        FileExtension jpegExtension = new FileExtensionImpl(firstBytesFromFile,inputFileExtension, ExtensionList.JPG);
        FileExtension gifExtension = new FileExtensionImpl(firstBytesFromFile,inputFileExtension, ExtensionList.GIF);
        FileExtension txtExtension = new FileExtensionImpl(firstBytesFromFile,inputFileExtension, ExtensionList.TXT);
        FileExtension bmpExtension = new FileExtensionImpl(firstBytesFromFile,inputFileExtension, ExtensionList.BMP);
        FileExtension pdfExtension = new FileExtensionImpl(firstBytesFromFile,inputFileExtension, ExtensionList.PDF);

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
