package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Train;

public class TrainShow {

        public static void show(Train T){
                T.toString();
                T.showLocomative();
                T.showCarriages();
                System.out.println("--\t--\t--");
        }
}
