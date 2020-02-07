import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
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

        String line = null;
        Set<String> str = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));

        while ((line = reader.readLine()) != null) {

            str.add(line);
        }

        for (String s: str)
            System.out.println(s);
    }
}
