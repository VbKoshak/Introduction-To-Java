package task3;

import java.util.Arrays;

public class MainTask {

        /*
        *найти индекс экстремального значения (минимальный и максимальный
        *элементы) данного вектора, если таких элементов нет, то возвратить -1;
        */
        private static int indexOfMaxEl(double[] arr) {
                int arrLength = arr.length;

                if (arrLength != 0) {

                        int maxIndex = 0;
                        double maxEl = arr[0];

                        for (int i = 1; i < arrLength; i++) {
                                if (maxEl < arr[i]) {
                                        maxEl = arr[i];
                                        maxIndex = i;
                                } else if (maxEl == arr[i]) {
                                        maxIndex = -1;
                                }
                        }

                        if (maxIndex == -1) {
                                System.out.println("There is at least 2 equal max values");
                        }

                        return maxIndex;

                } else {
                        System.out.println("Array should not be empty!");
                        return -1;
                }
        }

        private static int indexOfMinEl(double[] arr) {
                int arrLength = arr.length;

                if (arrLength != 0) {

                        int minIndex = 0;
                        double minEl = arr[0];

                        for (int i = 1; i < arrLength; i++) {
                                if (minEl > arr[i]) {
                                        minEl = arr[i];
                                        minIndex = i;
                                } else if (minEl == arr[i]) {
                                        minIndex = -1;
                                }
                        }

                        if (minIndex == -1) {
                                System.out.println("There is at least 2 equal min values");
                        }

                        return minIndex;

                } else {
                        System.out.println("Array should not be empty!");
                        return -1;
                }
        }

        public static String findExtrema(double[] arr){
                int maxIndex = indexOfMaxEl(arr);
                int minIndex = indexOfMinEl(arr);

                if (maxIndex + minIndex == -2) {
                        return "There is no extremes in array";
                } else if (maxIndex != -1 && minIndex != -1) {
                        return "max: " + maxIndex + "\nmin: " + minIndex;
                } else {
                        return "Index of extrema: " + ((maxIndex == -1)? minIndex : maxIndex);
                }
        }

        /*
        *найти среднеарифметическое и среднегеометрическое значения всех
        *элементов вектора;
         */

        private static double arythmAvg (double[] arr) {
                int length = arr.length;

                if (length == 0) {
                        System.out.println("Array can not be empty");
                        return 0;
                } else {
                        double sum = arr[0];

                        for (int i = 1; i < length; i++){
                                sum += arr[i];
                        }

                        sum /= length;

                        return sum;
                }
        }

        private static double geomAvg (double[] arr) {
                int length = arr.length;

                if (length == 0) {
                        System.out.println("Array can not be empty");
                        return 0;
                } else {
                        double res = arr[0];

                        for (int i = 1; i < length; i++){
                                res *= arr[i];
                        }

                        res  = Math.pow(res, (double)1/length);

                        return res;
                }
        }

        public static String findAvg (double[] arr) {
                double arAvg = arythmAvg(arr);
                double geAvg = geomAvg(arr);

                return "Arythmetic average: " + arAvg + "\nGeometric average: " + geAvg;
        }

        /*
        *проверить, находятся ли все элементы вектора в упорядоченном виде (т.е.
        *отсортированы ли элементы по возрастанию или убыванию);
         */

        // if 2-nd parameter == true -> isGrowing, if false -> is Descending
        private static boolean isGrowingOrDescending(double[] arr, boolean growingCondition){
                int length = arr.length;

                if (length == 0 || length == 1) {
                        System.out.println("Array's length is not big enough");
                        return false;
                } else {
                        double prevEl = arr[0];
                        boolean result = true;

                        if (growingCondition) {
                                for (int i = 1; i < length; i++) {
                                        if (prevEl >= arr[i]) {
                                                result = false;
                                                i = length;
                                        } else {
                                                prevEl = arr[i];
                                        }
                                }
                        } else {
                                for (int i = 1; i < length; i++) {
                                        if (prevEl <= arr[i]) {
                                                result = false;
                                                i = length;
                                        } else {
                                                prevEl = arr[i];
                                        }
                                }
                        }

                        return result;
                }
        }

        private static boolean isStreamlined(double[] arr) {
                boolean condition_1 = isGrowingOrDescending(arr,true);
                boolean condition_2 = isGrowingOrDescending(arr,false);

                if (condition_1 || condition_2) {
                        return true;
                } else {
                        return false;
                }
        }

        /*
        *найти позицию первого встретившегося локального минимума (максимума), а
        *если таких элементов нет, то возвратить -1 (локальный минимум это элемент,
        *который меньше любого из своих соседей; локальный максимум – это элемент,
        *который больше любого из своих соседей);
         */

        public static int findIndexOfLocalExtrema(double[] arr){
                int maxIndex = arr.length - 1;
                int returnValue = -1;

                boolean condition_1 = false;
                boolean condition_2 = false;
                boolean finalCondition_1 = false;
                boolean finalCondition_2 = false;

                if (maxIndex < 2){
                        System.out.println("Not enough elements in array");
                } else {
                        for (int i = 1; i < maxIndex; i++){
                                condition_1 = arr[i] > arr[i-1];
                                condition_2 = arr[i] > arr[i+1];

                                finalCondition_1 = (condition_1 && condition_2);
                                finalCondition_2 = (!condition_1 && !condition_2);

                                if (finalCondition_1 || finalCondition_2) {
                                        returnValue = i;
                                        i = maxIndex;
                                }
                        }
                }

                return returnValue;
        }

        /*
        *реализовать для элементов вектора два алгоритма поиска: линейный или
        последовательный (linear or sequential search) и двоичный или бинарный (binary
        search);
         */

        public static int linearSearh(double[] arr, double el) {
                int length = arr.length;

                int returnValue = -1;

                for (int i = 0; i < length; i++) {
                        if (arr[i] == el) {
                                returnValue = i;
                        }
                }

                return returnValue;
        }

        public static int binarySearch(double[] arr, int left, int right, double el) {
                if (right-left < 2) {
                        if (arr[left] == el) {
                                return left;
                        } else if (arr[right] == el) {
                                return right;
                        } else {
                                return -1;
                        }
                }

                int middle = (right+left)/2;

                double middleEl = arr[middle];

                if (middleEl == el) {
                        return middle;
                } else if (el > middleEl) {
                        return binarySearch(arr,middle,right,el);
                } else {
                        return binarySearch(arr,left,middle,el);
                }
        }

        /*
        *реверсировать все элементы вектора (при решении данного задания не
        *рекомендуется задействовать дополнительную память);
         */

        private static void swap (double[] arr, int firstIndex, int secondIndex){
                arr[firstIndex] += arr[secondIndex];
                arr[secondIndex] = arr[firstIndex] - arr[secondIndex];
                arr[firstIndex] -= arr[secondIndex];
        }

        /*
        *реализовать несколько алгоритмов сортировок элементов вектора по
        *возрастанию и убыванию (рекомендуется для реализации как минимум
        *следующие: сортировка обменом или пузырьковая сортировка (bubble sort), а
        *также её улучшенные версии; сортировка вставками (insertion sort); сортировка
        *выбором (selection sort); сортировка слиянием (merge sort) и быстрая сортировка
        *(quick sort).
         */



        public static void main (String[] args) {

                double[] vector = {1,3,6,9,10,11,14,18,20,23,25,27,30,50};
                double[] arr = {1,2,4,3};

                System.out.println(findExtrema(arr));
                System.out.println(findAvg(arr));
                System.out.println(isStreamlined(arr));
                System.out.println(findIndexOfLocalExtrema(arr));
                System.out.println(binarySearch(vector,0,vector.length,50));
                swap(arr,1,2);
                System.out.println(Arrays.toString(arr));
        }


}
