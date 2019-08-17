package by.epam.IntroductionToJava.task4.reader;

import by.epam.IntroductionToJava.task4.validators.WrongInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
        private static final Logger logger = LogManager.getLogger("READER");

        protected static String readFile(String fileName) throws WrongInputException{
                logger.traceEntry();
                char[] buf;
                String line = "";
                File file = new File(fileName);
                if (file.length() > 0) {
                        try (FileReader reader = new FileReader(file)) {
                                buf = new char[256];
                                reader.read(buf);
                                line = new String(buf);
                        } catch (IOException ex) {
                                logger.error(ex);
                                System.out.println(ex.getMessage());
                        }
                } else {
                        logger.error("File is empty or can not be found");
                        throw new WrongInputException("File is empty or can not be found", 0, "ERR");
                }
                return line;
        }
        protected static String[][] getConstructorIntructions(String text){
                logger.traceEntry();
                String[] arr = text.split("\n");
                String[][] mtx = new String[arr.length][];
                for (int i = 0; i < arr.length; i++) {
                        mtx[i] = arr[i].split(" ");
                }
                return mtx;
        }
}
