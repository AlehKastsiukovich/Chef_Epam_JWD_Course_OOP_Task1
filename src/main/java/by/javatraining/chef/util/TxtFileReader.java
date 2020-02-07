package by.javatraining.chef.util;

import by.javatraining.chef.exception.UtilException;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtFileReader {
    private static final Logger logger = Logger.getLogger(TxtFileReader.class);

    public static class TxtFileReaderHandler {
        public static final TxtFileReader txtFileReader = new TxtFileReader();
    }

    public static TxtFileReader getInstance() {
        return TxtFileReaderHandler.txtFileReader;
    }

    public List<String> readTxtFile() throws UtilException {
        BufferedReader bufferedReader = null;
        String pathFile = null;
        String line = null;
        List<String> stringObjects = new ArrayList<>();

        try {
            pathFile = getClass().getClassLoader().getResource("vegetable.txt").getFile();
            bufferedReader = new BufferedReader(new FileReader(pathFile));
        } catch (FileNotFoundException e) {
            logger.error("File vegetable.txt not find!", e);
            throw new UtilException();
        }

        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringObjects.add(line);
            }
        } catch (IOException e) {
            logger.error("Can't read file!", e);
            throw new UtilException();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                logger.error("Can't close bufferedReader stream!", e);
                throw new UtilException();
            }
        }

        return stringObjects;
    }
}



