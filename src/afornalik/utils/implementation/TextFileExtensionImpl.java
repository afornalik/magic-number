package afornalik.utils.implementation;

import afornalik.utils.FileExtension;
import afornalik.utils.exception.ExtensionNotSupportedException;

import java.util.regex.Pattern;

public class TextFileExtensionImpl extends FileExtension {

    private FileExtension nextChain;

    public TextFileExtensionImpl(byte[] firstBytesFromFile, String inputFileExtension, ExtensionList extensionList) {
        super(firstBytesFromFile, inputFileExtension, extensionList);
    }


    @Override
    public void checkTheExtension() throws ExtensionNotSupportedException {
        boolean matcher = Pattern.matches(super.getEXPECTED_EXTENSION()[0], firstStringFromFile());
        if (matcher) {
            System.out.print("File type is : " + super.getFILE_EXTENSION());
            if (getInputFileExtension().toUpperCase().equals(super.getFILE_EXTENSION())) {
                System.out.println(" and is correct");
            } else {
                System.out.println(" Error ! Extension is ." + getInputFileExtension() + " , while actually it's a " + super.getFILE_EXTENSION());
            }
        } else {
            //System.out.println("File type is not : " + super.getFILE_EXTENSION());
            if (this.nextChain == null) {
                throw new ExtensionNotSupportedException(" Extension not supported ");
            } else {
                this.nextChain.checkTheExtension();
            }
        }
    }

    private String firstStringFromFile() {
        StringBuilder firstStringFromFile = new StringBuilder();
        for (byte b : super.getFirstByteFromFile()) {
            firstStringFromFile.append((char) b);
        }
        return firstStringFromFile.toString();
    }

    @Override
    public void setNextChain(FileExtension nextChain) {
        this.nextChain = nextChain;
    }
}
