package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.LiquidCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriageWithRooms;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {

        public static void sortById(Carriage[] arr) {
                Arrays.sort(arr, (o1, o2) -> (o1.getId() - o2.getId()));
        }

        public static void sortByYear(Carriage[] arr){
                Comparator<Carriage> comparator = (Carriage o1, Carriage o2) -> (o1.getYearOfConstruction() - o2.getYearOfConstruction());
                Arrays.sort(arr,comparator);
        }

        public static void sortByModel(Carriage[] arr){
                Arrays.sort(arr, (o1, o2) -> (o1.getModel().compareToIgnoreCase(o2.getModel())));
        }

        public static void sortByHook(Carriage[] arr){
                Comparator<Carriage> comparator = Comparator.comparing(obj->obj.getHook().ordinal());
                comparator.thenComparing(obj->obj.getId());
                Arrays.sort(arr, comparator);
        }

        public static void main(String[] args) {
                Carriage[] arr = new Carriage[3];
                arr[0] = new Carriage((short)1978,102,2000,"Shorter",TypeOfHook.A);
                arr[1] = new LiquidCarrier((short)1975,208,2500,"Transporter S3000",TypeOfHook.B,"Milk",15_200,false,true);
                arr[2] = new PassangerCarriageWithRooms((short)2005,380,4000,"Delurio",TypeOfHook.A,100,34,2);

                sortByYear(arr);

                CarriageShow.show(arr);

                sortByHook(arr);

                CarriageShow.show(arr);


        }
}
