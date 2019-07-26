package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTaskTest {

        private static String getNumsFromString(String str){
                return str.replaceAll("[^-?0-9*.?0-9?]+", " ");        // extracting all numbers
                /*
                 * change all characters that a not a part of number to whitespace
                 * result is usually like:
                 * whitespace in the beginning and the end of the string
                 * numbers are derived with a whitespace as well
                 * example: " 0 1 2 3 "
                 * double values use point
                 * example: " 1.0 2.0 "
                 */
        }

        @Test
        public void linearSearch() {
                double[] arr = {1,2,10,6,5,4,6,7,8,3,4,5};
                int res = MainTask.linearSearch(arr,3);
                assertEquals(9,res);
        }

        @Test
        public void binarySearch() {
                double[] arr = {1,2,3,4,5,6,7,8,10,13,14,15};
                int res = MainTask.binarySearch(arr,0,arr.length,5);
                assertEquals(4,res);
        }

        @Test
        public void reverseArray() {
                double[] arr_1 = {1,2,3,6,5,4,6,7,8,3,4,5};
                double[] exp_1 = {5,4,3,8,7,6,4,5,6,3,2,1};
                MainTask.reverseArray(arr_1);
                assertArrayEquals(exp_1,arr_1,0);
                double[] arr_2 = {1,2,3,4};
                double[] exp_2 = {1,2,3,4};
                MainTask.reverseArray(arr_2);
                MainTask.reverseArray(arr_2);
                assertArrayEquals(exp_2,arr_2,0);
        }

        @Test
        public void bubbleSort() {
                double[] arr = {3,4,2,6,1,7,5,9,8};
                double[] exp = {1,2,3,4,5,6,7,8,9};
                MainTask.bubbleSort(arr);
                assertArrayEquals(exp,arr,0);
        }

        @Test
        public void insertionSort() {
                double[] arr = {3,4,2,6,1,7,5,9,8};
                double[] exp = {1,2,3,4,5,6,7,8,9};
                MainTask.insertionSort(arr);
                assertArrayEquals(exp,arr,0);
        }

        @Test
        public void selectionSort() {
                double[] arr = {3,4,2,6,1,7,5,9,8};
                double[] exp = {1,2,3,4,5,6,7,8,9};
                MainTask.selectionSort(arr);
                assertArrayEquals(exp,arr,0);
        }

        @Test
        public void mergeSort() {
                double[] arr = {3,4,2,6,1,7,5,9,8};
                double[] exp = {1,2,3,4,5,6,7,8,9};
                MainTask.mergeSort(arr,0,arr.length-1);
                assertArrayEquals(exp,arr,0);
        }

        @Test
        public void quickSort() {
                double[] arr = {3,4,2,6,1,7,5,9,8};
                double[] exp = {1,2,3,4,5,6,7,8,9};
                MainTask.quickSort(arr,0,arr.length-1);
                assertArrayEquals(exp,arr,0);
        }

        @Test
        public void findExtrema_1() {
                double[] arr = {1,2,3,4,5,6,7,8,9};

                String res = getNumsFromString(MainTask.findExtrema(arr));
                assertTrue(" 8 0 ".equals(res));
        }

        @Test
        public void findExtrema_2() {
                double[] arr = {2,2,3,4,5,6,7,8,9};

                String res = getNumsFromString(MainTask.findExtrema(arr));
                assertTrue(" 8 ".equals(res));
        }

        @Test
        public void findExtrema_3() {
                double[] arr = {2,2,3,4,5,6,7,8,8};

                String res = getNumsFromString(MainTask.findExtrema(arr));
                assertTrue(" ".equals(res));
        }

        @Test
        public void isStreamlined_1() {
                double[] arr = {1,2,3,4,5};

                assertTrue(MainTask.isStreamlined(arr));
        }

        @Test
        public void isStreamlined_2() {
                double[] arr = {8,6,4,2,1};

                assertTrue(MainTask.isStreamlined(arr));
        }

        @Test
        public void isStreamlined_3() {
                double[] arr = {1,2,9,4,2};

                assertFalse(MainTask.isStreamlined(arr));
        }

        @Test
        public void findAvg(){
                double[] arr = {1,2,2,4};

                assertTrue(" 2.25 2.0 ".equals(getNumsFromString(MainTask.findAvg(arr))));
        }

        @Test
        public void findIndexOfLocalExtrema(){
                double[] arr = {1,2,3,4,3,5,6};

                assertEquals(3,MainTask.findIndexOfLocalExtrema(arr));
        }
}