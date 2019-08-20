package by.epam.IntroductionToJava.task4.reader;

import by.epam.IntroductionToJava.task4.validators.WrongInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
        private static final Logger logger = LogManager.getLogger("READER");

        //method that reads file with instructions and returns a string that should be sent to {getConstructorInstructions}
        protected static String readFile(String fileName) throws WrongInputException{
                logger.traceEntry();
                char[] buf;
                String line = "";
                File file = new File(fileName);
                final String errorMSG = "File is empty or can not be found";
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
                        logger.error(errorMSG);
                        throw new WrongInputException(errorMSG, 0, "ERR");
                }
                return line;
        }
}
