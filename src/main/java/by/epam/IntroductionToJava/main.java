package by.epam.IntroductionToJava;

import by.epam.IntroductionToJava.task4.action.Show;
import by.epam.IntroductionToJava.task4.entity.Train;
import by.epam.IntroductionToJava.task4.reader.Factory;

public class main {
    public static void main (String[] args) {
        Train t1 = Factory.buildTrainFromFile("example.txt");
        Show.showTrain(t1);
    }

}

