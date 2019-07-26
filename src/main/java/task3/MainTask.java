package task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MainTask {

        private static Logger logger = LogManager.getLogger();



        /*
        *найти индекс экстремального значения (минимальный и максимальный
        *элементы) данного вектора, если таких элементов нет, то возвратить -1;
        */
        private static int indexOfMaxEl(double[] arr) {

                logger.traceEntry(Arrays.toString(arr));

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

                        return logger.traceExit(maxIndex);

                } else {
                        System.out.println("Array should not be empty!");
                        return logger.traceExit(-1);
                }
        }

        private static int indexOfMinEl(double[] arr) {

                logger.traceEntry(Arrays.toString(arr));

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

                        return logger.traceExit(minIndex);

                } else {
                        System.out.println("Array should not be empty!");
                        return logger.traceExit(-1);
                }
        }

        public static String findExtrema(double[] arr){
                logger.traceEntry(Arrays.toString(arr));

                int maxIndex = indexOfMaxEl(arr);
                int minIndex = indexOfMinEl(arr);

                if (maxIndex + minIndex == -2) {
                        return logger.traceExit("There is no extremes in array");
                } else if (maxIndex != -1 && minIndex != -1) {
                        return logger.traceExit("max: " + maxIndex + "\nmin: " + minIndex + " ");
                } else {
                        return logger.traceExit("Index of extrema: " + ((maxIndex == -1)? minIndex : maxIndex) + " ");
                }
        }

        /*
        *найти среднеарифметическое и среднегеометрическое значения всех
        *элементов вектора;
         */

        private static double arythmAvg (double[] arr) {
                logger.traceEntry(Arrays.toString(arr));

                int length = arr.length;

                if (length == 0) {
                        System.out.println("Array can not be empty");
                        return logger.traceExit(0);
                } else {
                        double sum = arr[0];

                        for (int i = 1; i < length; i++){
                                sum += arr[i];
                        }

                        sum /= length;

                        return logger.traceExit(sum);
                }
        }

        private static double geomAvg (double[] arr) {
                logger.traceEntry(Arrays.toString(arr));

                int length = arr.length;

                if (length == 0) {
                        System.out.println("Array can not be empty");
                        return logger.traceExit(0);
                } else {
                        double res = arr[0];

                        for (int i = 1; i < length; i++){
                                res *= arr[i];
                        }

                        res  = Math.pow(res, (double)1/length);

                        return logger.traceExit(res);
                }
        }

        public static String findAvg (double[] arr) {
                logger.traceEntry(Arrays.toString(arr));

                double arAvg = arythmAvg(arr);
                double geAvg = geomAvg(arr);

                return logger.traceExit("Arythmetic average: " + arAvg + "\nGeometric average: " + geAvg + " ");
        }

        /*
        *проверить, находятся ли все элементы вектора в упорядоченном виде (т.е.
        *отсортированы ли элементы по возрастанию или убыванию);
         */

        // if 2-nd parameter == true -> isGrowing, if false -> is Descending
        private static boolean isGrowingOrDescending(double[] arr, boolean growingCondition){
                logger.traceEntry(Arrays.toString(arr), growingCondition);

                int length = arr.length;

                if (length == 0 || length == 1) {
                        System.out.println("Array's length is not big enough");
                        return logger.traceExit(false);
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

                        return logger.traceExit(result);
                }
        }

        public static boolean isStreamlined(double[] arr) {
                logger.traceEntry(Arrays.toString(arr));

                boolean condition_1 = isGrowingOrDescending(arr,true);
                boolean condition_2 = isGrowingOrDescending(arr,false);

                if (condition_1 || condition_2) {
                        return logger.traceExit(true);
                } else {
                        return logger.traceExit(false);
                }
        }

        /*
        *найти позицию первого встретившегося локального минимума (максимума), а
        *если таких элементов нет, то возвратить -1 (локальный минимум это элемент,
        *который меньше любого из своих соседей; локальный максимум – это элемент,
        *который больше любого из своих соседей);
         */

        public static int findIndexOfLocalExtrema(double[] arr){
                logger.traceEntry(Arrays.toString(arr));

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

                return logger.traceExit(returnValue);
        }

        /*
        *реализовать для элементов вектора два алгоритма поиска: линейный или
        последовательный (linear or sequential search) и двоичный или бинарный (binary
        search);
         */

        public static int linearSearh(double[] arr, double el) {
                logger.traceEntry(Arrays.toString(arr), el);

                int length = arr.length;

                int returnValue = -1;

                for (int i = 0; i < length; i++) {
                        if (arr[i] == el) {
                                returnValue = i;
                        }
                }

                return logger.traceExit(returnValue);
        }

        public static int binarySearch(double[] arr, int left, int right, double el) {
                logger.traceEntry(Arrays.toString(arr), left, right, el);

                if (right-left < 2) {
                        if (arr[left] == el) {
                                return logger.traceExit(left);
                        } else if (arr[right] == el) {
                                return logger.traceExit(right);
                        } else {
                                return logger.traceExit(-1);
                        }
                }

                int middle = (right+left)/2;

                double middleEl = arr[middle];

                if (middleEl == el) {
                        return logger.traceExit(middle);
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
                logger.traceEntry(Arrays.toString(arr), firstIndex, secondIndex);

                arr[firstIndex] += arr[secondIndex];
                arr[secondIndex] = arr[firstIndex] - arr[secondIndex];
                arr[firstIndex] -= arr[secondIndex];
                logger.traceExit();
        }

        public static void reverseArray(double[] arr) {
                logger.traceEntry(Arrays.toString(arr));
                int length = arr.length;
                int middle = length/2;
                length--;

                for (int i = 0; i < middle; i++) {
                        swap(arr,i,length-i);
                }
                logger.traceExit();
        }

        /*
        *реализовать несколько алгоритмов сортировок элементов вектора по
        *возрастанию и убыванию (рекомендуется для реализации как минимум
        *следующие: сортировка обменом или пузырьковая сортировка (bubble sort), а
        *также её улучшенные версии; сортировка вставками (insertion sort); сортировка
        *выбором (selection sort); сортировка слиянием (merge sort) и быстрая сортировка
        *(quick sort).
         */

        public static void bubbleSort(double[] arr) {
                logger.traceEntry(Arrays.toString(arr));

                int length = arr.length - 1;
                int border;

                for (int i = 0; i < length; i++){
                        border = length - i;                            // not to sort sorted part
                        for (int j = 0; j < border; j++){
                                if (arr[j] > arr[j+1]){
                                        swap(arr,j,j+1);
                                }
                        }
                }
                logger.traceExit();
        }

        public static void insertionSort(double[] arr) {
                logger.traceEntry(Arrays.toString(arr));

                int length = arr.length;
                double el;
                int inner;

                for (int outer = 1; outer < length; outer++){
                        el = arr[outer];
                        inner = 0;

                        while (el > arr[inner]){                        // finding the index where el should be
                                inner++;
                        }

                        if (inner < outer){                             // check if it is in sorted part
                                for (int i = outer; i > inner;){        // pushing the array to place our element
                                        swap(arr,i,--i);
                                }
                        }
                }
                logger.traceExit();
        }

        public static void selectionSort(double[] arr) {
                logger.traceEntry(Arrays.toString(arr));

                int length = arr.length;
                double min;                                             // min value
                int minIndex;                                           // index of min value

                int border = length-1;
                for (int i = 0; i < border; i++) {
                        min = arr[i];
                        minIndex = i;

                        for (int j = i+1; j < length; j++){
                                if (arr[j] < min) {
                                        min = arr[j];
                                        minIndex = j;
                                }
                        }

                        if (minIndex != i) {
                                swap(arr,i,minIndex);
                        }
                }
                logger.traceExit();
        }

        private static void merge(double[] arr, int left, int middle, int right) {
                logger.traceEntry(Arrays.toString(arr), left, middle, right);

                int size = right-left+1;                                        // size of a temporary array
                double[] temp = new double[size];
                int index= 0;                                                   // index for pushing in temp array

                int leftCopy = left;
                int rightPartStart = ++middle;

                right++;                                                        // not to use <=

                while (left < middle && rightPartStart < right) {               // sorting in a temp array
                        if (arr[left] < arr[rightPartStart]){
                                temp[index++] = arr[left++];
                        } else {
                                temp[index++] = arr[rightPartStart++];
                        }
                }

                if (left < middle) {                                  // finish sorting by adding the biggest numbers
                        for (int i = left; i < middle;) {
                                temp[index++] = arr[i++];
                        }
                } else if (rightPartStart < right) {
                        for (int i = rightPartStart; i < right;){
                                temp[index++] = arr[i++];
                        }
                }

                for (int i = 0; i < size;i++,leftCopy++) {                      // copying from temp array to basic
                        arr[leftCopy] = temp[i];
                }
                logger.traceExit();
        }

        public static void mergeSort(double[] arr, int left, int right){
                logger.traceEntry(Arrays.toString(arr), left, right);

                int length = right - left;

                if (length == 1) {                                              // sorting if array length = 2, too
                                                                                // not so hard to make another function
                        if (arr[left] > arr[right]){
                                swap(arr,left,right);
                        }

                } else if (length > 1) {

                        int middle = (left + right)/2;

                        mergeSort(arr,left,middle);                             // sorting left part
                        mergeSort(arr,middle+1,right);                     // sorting right part

                        merge(arr,left,middle,right);                           // merging halfs
                }
                logger.traceExit();
        }

        public static void quickSort (double[] arr, int left, int right) {
                logger.traceEntry(Arrays.toString(arr), left, right);
                int i = left;
                int j = right;

                double midEl = arr[(left+right)/2];

                do {
                        while (arr[i] < midEl) {
                                i++;
                        }
                        while (arr[j] > midEl) {
                                j--;
                        }

                        if (i <= j) {
                                if (i != j){
                                        swap(arr,i,j);
                                }
                                i++;
                                j--;
                        }

                } while (i < j);

                if (i < right) quickSort(arr, i, right);
                if (j > left) quickSort(arr, left, j);
                logger.traceExit();
        }

        public static void main(String[] args) {
                double[] arr = {1,2,3,4,5,6};

                String a = findExtrema(arr);

                System.out.println(a);
        }
}
