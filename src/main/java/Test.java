import by.javatraining.chef.exception.UtilException;
import by.javatraining.chef.util.TxtFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) throws IOException {

//        byte[] filebytes = Files.readAllBytes(Paths.get("text.txt"));
//        String string = new String(filebytes);
//        System.out.println(string);
//        char[] ch = string.toCharArray();
//
//        for (Character character : ch) {
//            System.out.println(character);
//        }

        TxtFileReader txtFileReader = new TxtFileReader();
        List<String> list = null;
        try {
            list = txtFileReader.readTxtFile();
        } catch (UtilException e) {
            e.printStackTrace();
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
