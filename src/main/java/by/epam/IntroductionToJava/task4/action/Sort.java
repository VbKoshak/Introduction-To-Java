package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.LiquidCarrier;

import java.util.Arrays;

public class Sort {

        public static void sortById(Carriage[] arr) {
                Arrays.sort(arr, (o1, o2) -> (o1.getId() - o2.getId()));
        }

        public static void sortByYear(Carriage[] arr){
                Arrays.sort(arr, (o1, o2) -> (o1.getYearOfConstruction() - o2.getYearOfConstruction()));
        }

        public static void sortByModel(Carriage[] arr){
                Arrays.sort(arr, (o1, o2) -> (o1.getModel().compareToIgnoreCase(o2.getModel())));
        }

        public static void sortByHook(Carriage[] arr){
                Arrays.sort(arr, (o1,o2) -> (o1.getHook().ordinal() - o2.getHook().ordinal()));
        }

        public static void main(String[] args) {
                Carriage[] arr = new Carriage[2];
                arr[0] = new Carriage((short)1972,102,20,"Shorter",TypeOfHook.A);
                arr[1] = new LiquidCarrier((short)1975,208,25,"Transporter S3000",TypeOfHook.B,"Milk",15_200,false,true);

                sortByHook(arr);
                System.out.println(arr[0].getModel());

                for (Carriage car: arr){
                        System.out.println(car.toString());
                }
        }
}
