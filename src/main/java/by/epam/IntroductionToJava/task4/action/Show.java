package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.Locomative;
import by.epam.IntroductionToJava.task4.entity.Train;

public class Show {

        private final static String LINE = "--\t--\t--";



        public static void showCarriages(Carriage[] arr){
                System.out.println("Carriages");
                for (Carriage car: arr){
                        System.out.println(car.toString());
                }

        }

        public static void showCarriages(Train T){
                showCarriages(T.getCarriages());
        }

        public static void showLocomative(Locomative L){
                System.out.println(L.toString());
        }

        public static void showLocomative(Train T){
                System.out.println(T.getLocomative().toString());
        }

        public static void showTrain(Train T){
                System.out.println(LINE);
                T.toString();
                showLocomative(T);
                showCarriages(T);
                System.out.println(LINE);
        }

        public static void showCarriage(Carriage car){
                System.out.println(car.toString());
        }
}
