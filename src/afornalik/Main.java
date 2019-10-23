package afornalik;

import afornalik.model.extension.ExtensionList;
import afornalik.model.FileExtension;
import afornalik.model.extension.FileExtensionImpl;

import java.io.*;

public class Main {


    private final static String CURRENT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) {

        File file = new File(CURRENT_PATH+"\\"+"ss.jpg");

        FileExtension jpeg = new FileExtensionImpl(file, ExtensionList.JPEG);
        FileExtension gif = new FileExtensionImpl(file, ExtensionList.GIF);

        jpeg.checkTheExtension();



    /*    Scanner scanner = new Scanner(System.in);

        System.out.println("You are actually located : ");
        System.out.print(CURRENT_PATH+"\n\n");

        System.out.println("Write file name :");
        String filePath = scanner.next();

        File file = new File(CURRENT_PATH+"\\"+"ss.gif");
        File file2 = new File(CURRENT_PATH+"\\"+"giphy1.gif");
        File file3 = new File(CURRENT_PATH+"\\"+"some.txt");
        System.out.println(file.exists());

        byte[] fileByteArray = new byte[(int)file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileByteArray);
            fileInputStream.close();

            byte[] array = Files.readAllBytes(file.toPath());
            byte[] array2 = Files.readAllBytes(file2.toPath());
            byte[] array3 = Files.readAllBytes(file3.toPath());

            for(int i = 0; i < 200 ; i++){
                System.out.print((char)array[i]);
            }
            System.out.println();
            for(int i = 0; i < 200 ; i++){
                System.out.print((char)array2[i]);
            }


            System.out.println();
            for(int i = 0; i < 200 ; i++){
                System.out.print(array3[i]);
            }

            String test = "";
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/
    }
}
