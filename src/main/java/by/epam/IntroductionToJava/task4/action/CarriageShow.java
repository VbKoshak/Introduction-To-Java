package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;

import java.util.ArrayList;

public class CarriageShow {
        public static void show(Carriage[] arr){
                System.out.println("Carriages");
                for (Carriage car: arr){
                        System.out.println(car.toString());
                }
                //System.out.println("//\t\t\t//");

        }

        public static void show(ArrayList<Carriage> cars){
                System.out.println("Carriages");
                for (Carriage car: cars){
                        System.out.println(car.toString());
                }
        }

        public static void show(Carriage car){
                System.out.println(car.toString());
        }
}
