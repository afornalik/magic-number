package afornalik.model.implementation;

import afornalik.model.FileExtension;
import afornalik.model.exception.ExtensionNotSupportedException;


public class FileExtensionImpl extends FileExtension {

    private FileExtension nextChain;

    public FileExtensionImpl(byte[] firstBytesFromFile , String inputFileExtension, ExtensionList extensionList) {
        super(firstBytesFromFile,inputFileExtension, extensionList);
    }

    @Override
    public void checkTheExtension() throws ExtensionNotSupportedException {
        StringBuilder firstStringFromFile = new StringBuilder();
        for (byte b : super.getFirstByteFromFile()) {
            firstStringFromFile.append((char) b);
        }
        if (firstStringFromFile.toString().contains(super.getEXPECTED_EXTENSION())) {
            System.out.print("File type is : "+ super.getFILE_EXTENSION());
            if(getInputFileExtension().toUpperCase().equals(super.getFILE_EXTENSION())){
                System.out.println(" and is correct");
            }else {
                System.out.println(" Error ! Extension is ."+getInputFileExtension()+" , while actually it's a "+super.getFILE_EXTENSION());
            }
        } else {
            System.out.println("File type is not : "+ super.getFILE_EXTENSION());
            if(this.nextChain != null){
                this.nextChain.checkTheExtension();
            }else {
                throw new ExtensionNotSupportedException(" Extension not supported ");
            }
        }
    }

    @Override
    public void setNextChain(FileExtension nextChain) {
        this.nextChain = nextChain;
    }
}
