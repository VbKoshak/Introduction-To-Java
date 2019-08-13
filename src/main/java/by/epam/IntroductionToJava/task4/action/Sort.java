package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {

        public static void sortById(Carriage[] arr) {
                Arrays.sort(arr, (o1, o2) -> (o1.getId() - o2.getId()));
        }

        public static void sortByYear(Carriage[] arr){
                Comparator<Carriage> comparator = (Carriage o1, Carriage o2) -> (o1.getYearOfConstruction() - o2.getYearOfConstruction());
                comparator.thenComparing(obj->obj.getId());
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
}
