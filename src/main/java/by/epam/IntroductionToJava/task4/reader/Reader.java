package by.epam.IntroductionToJava.task4.reader;

import by.epam.IntroductionToJava.task4.action.Show;
import by.epam.IntroductionToJava.task4.entity.Train;

import java.io.FileReader;
import java.io.IOException;

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

        public static void main(String[] args) {
                String line = Reader.readFile("example.txt");
                System.out.println(line);
                String[][] constructorInstructions = getConstructorIntructions(line);
                Train T = Factory.createTrain(constructorInstructions);
                Show.showTrain(T);
        }
}
