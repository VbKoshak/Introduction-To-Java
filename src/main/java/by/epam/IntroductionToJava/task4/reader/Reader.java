package by.epam.IntroductionToJava.task4.reader;

import by.epam.IntroductionToJava.task4.action.Show;
import by.epam.IntroductionToJava.task4.entity.Train;
import by.epam.IntroductionToJava.task4.validators.WrongInputException;

import java.io.FileReader;
import java.io.IOException;

import static by.epam.IntroductionToJava.task4.validators.constructorInstructionsValidator.checkInstructions;

public class Reader {

        private static String readFile(String fileName){
                char[] buf;
                String line = "";
                try(FileReader reader = new FileReader(fileName))
                {
                        buf = new char[256];
                        reader.read(buf);
                        line = new String(buf);
                }
                catch(IOException ex){
                        System.out.println(ex.getMessage());
                }
                return line;
        }


        private static String[][] getConstructorIntructions(String text){
                String[] arr = text.split("\n");
                String[][] mtx = new String[arr.length][];
                for (int i = 0; i < arr.length; i++) {
                        mtx[i] = arr[i].split(" ");
                }
                return mtx;
        }

//        public static Train buildTrainFromFile(String filename){
//
//        }

        public static void main(String[] args) {
                String line = Reader.readFile("example.txt");
                String[][] constructorInstructions = getConstructorIntructions(line);
                try{
                        checkInstructions(constructorInstructions);
                        Train T = Factory.createTrain(constructorInstructions);
                        Show.showTrain(T);
                } catch (WrongInputException ex){
                        System.out.println(ex.getMessage());
                        System.out.println("on line: " + ex.getLine());
                }
        }
}
