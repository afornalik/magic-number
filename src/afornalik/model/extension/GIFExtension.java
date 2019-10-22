package afornalik.model.extension;

import afornalik.model.FileExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class GIFExtension extends FileExtension {

    FileExtension nextChain;

    public GIFExtension(File file, ExtensionList extensionList) {
        super(file,extensionList);
    }

    @Override
    public void checkTheExtension() {
        try {
            byte[] array = Files.readAllBytes(super.getFile().toPath());
            byte[] firstPart = Arrays.copyOf(array,30);
            StringBuilder stringBuilder = new StringBuilder();
            for(byte b : firstPart){
                stringBuilder.append((char)b);
            }
            String s =super.getEXPECTED_EXTENSION();
            String in = stringBuilder.toString();
            if(in.contains(s)){
                System.out.println("true");
            }else {
                this.nextChain.checkTheExtension();
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setNextChain(FileExtension nextChain) {
        this.nextChain = nextChain;
    }
}
