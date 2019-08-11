package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;

import java.util.ArrayList;

public class CarriageShow {
        public static void show(Carriage[] arr){
                for (Carriage car: arr){
                        System.out.println(car.toString());
                }
        }

        public static void show(ArrayList<Carriage> cars){
                for (Carriage car: cars){
                        show(car);
                }
        }

        public static void show(Carriage car){
                System.out.println(car.toString());
        }
}
