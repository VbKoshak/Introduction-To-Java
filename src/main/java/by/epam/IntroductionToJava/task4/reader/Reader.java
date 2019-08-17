package by.epam.IntroductionToJava.task4.reader;

import by.epam.IntroductionToJava.task4.entity.Train;
import by.epam.IntroductionToJava.task4.validators.WrongInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static by.epam.IntroductionToJava.task4.validators.constructorInstructionsValidator.checkInstructions;

public class Reader {
        private static final Logger logger = LogManager.getLogger("READER");

        private static String FILE_PATH = "src/main/java/by/epam/IntroductionToJava/task4/inputFiles/";

        private static String readFile(String fileName) throws WrongInputException{
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


        private static String[][] getConstructorIntructions(String text){
                logger.traceEntry();
                String[] arr = text.split("\n");
                String[][] mtx = new String[arr.length][];
                for (int i = 0; i < arr.length; i++) {
                        mtx[i] = arr[i].split(" ");
                }
                return mtx;
        }

        public static Train buildTrainFromFile(String filename){
                logger.traceEntry(filename);
                Train T = new Train();
                try {
                        String line = Reader.readFile(FILE_PATH + filename);
                        String[][] constructorInstructions = getConstructorIntructions(line);
                        checkInstructions(constructorInstructions);
                        T = Factory.createTrain(constructorInstructions);
                } catch (WrongInputException ex){
                        logger.error(ex);
                        System.out.println(ex.getType() + ": " + ex.getMessage());
                        System.out.println("\ton line: " + ex.getLine());
                } catch (Exception ex){
                        logger.error(ex);
                        System.out.println(ex.getMessage());
                } finally {
                        return logger.traceExit(T);
                }
        }
}
