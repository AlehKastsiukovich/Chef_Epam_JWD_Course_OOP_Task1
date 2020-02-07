package by.javatraining.chef.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TxtFileReader {

    public List<String> readTxtFile(String fileUrl) {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileUrl));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
