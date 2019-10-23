package afornalik;

import afornalik.model.implementation.ExtensionList;
import afornalik.model.FileExtension;
import afornalik.model.implementation.FileExtensionImpl;
import afornalik.service.FileService;
import afornalik.service.IFileService;

import java.io.*;

public class Main {


    private final static String CURRENT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) {

        File file = new File(CURRENT_PATH+"\\"+"Checked.bmp");
        IFileService fileService = new FileService(file);

        String inputFileExtension = fileService.returnInputFileExtension();

        byte[] firstBytesFromFile = fileService.returnFirstByteFromFile();

        FileExtension jpegExtension = new FileExtensionImpl(firstBytesFromFile, ExtensionList.JPEG);
        FileExtension gifExtension = new FileExtensionImpl(firstBytesFromFile, ExtensionList.GIF);
        FileExtension txtExtension = new FileExtensionImpl(firstBytesFromFile, ExtensionList.TXT);
        FileExtension bmpExtension = new FileExtensionImpl(firstBytesFromFile, ExtensionList.BMP);
        FileExtension pdfExtension = new FileExtensionImpl(firstBytesFromFile, ExtensionList.PDF);

        jpegExtension.setNextChain(gifExtension);
        gifExtension.setNextChain(txtExtension);
        txtExtension.setNextChain(bmpExtension);
        bmpExtension.setNextChain(pdfExtension);

        jpegExtension.checkTheExtension();



    }
}
