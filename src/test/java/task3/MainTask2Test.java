package task3;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTask2Test {

        private static String getNumsFromString(String str){
                return str.replaceAll("[^-?0-9*.?0-9?]+", " ");        // выбираем все числа
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

        private static String stringFromMtx(double[][] mtx) {
                String res = "";
                int length = mtx.length;

                for (int i = 0; i < length; i++){
                        res += Arrays.toString(mtx[i]);
                }

                return res;
        }

        @Test
        public void findExtrema_1() {
                double[][] mtx = {
                        {3,2,3},
                        {5,9,4},
                        {7,2,1}
                };

                String res = MainTask2.findExtrema(mtx);
                res = getNumsFromString(res);

                assertTrue(" 1 1 2 2 ".equals(res));
                // first two numbers - indexes of max element
                // second two numbers - min element
        }

        @Test
        public void findExtrema_2() {
                double[][] mtx_2 = {
                        {1,1},
                        {1,1}
                };

                String res_2 = MainTask2.findExtrema(mtx_2);
                res_2 = getNumsFromString(res_2);

                assertTrue(" 0 0 0 0 ".equals(res_2));
        }

        @Test
        public void findIndexOfLocalExtrema_1() {
                double[][] mtx = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
                int[] exp = {0,0};

                int[] res = MainTask2.findIndexOfLocalExtrema(mtx);

                assertArrayEquals(exp,res);
        }

        @Test
        public void findIndexOfLocalExtrema_2() {
                double mtx[][] = {
                        {1,2,3},
                        {1,5,8},
                        {7,6,0}
                };
                int[] exp = {1,2};

                int[] res = MainTask2.findIndexOfLocalExtrema(mtx);

                assertArrayEquals(exp,res);
        }

        @Test
        public void matrixTransposition() {
                double mtx[][] = {
                        {1,2,3},
                        {1,5,8},
                        {7,6,0}
                };

                double exp[][] = {
                        {1,1,7},
                        {2,5,6},
                        {3,8,0}
                };

                MainTask2.matrixTransposition(mtx);

                assertTrue(stringFromMtx(exp).equals(stringFromMtx(mtx)));
        }

        @Test
        public void isSymetric_1() {
                double mtx[][] = {
                        {1,2,3},
                        {2,1,4},
                        {3,4,1}
                };

                assertTrue(MainTask2.isSymetric(mtx));
        }

        @Test
        public void isSymetric_2() {
                double mtx[][] = {
                        {9,2,1},
                        {5,1,2},
                        {1,5,9}
                };

                assertTrue(MainTask2.isSymetric(mtx));
        }

        @Test
        public void isSymetric_3() {
                double mtx[][] = {
                        {1,2,3},
                        {2,1,8},
                        {3,4,1}
                };

                assertFalse(MainTask2.isSymetric(mtx));
        }

        @Test
        public void findAvg() {
                double mtx[][] = {
                        {1,2},
                        {1,8}
                };

                assertTrue(" 3.0 2.0 ".equals(getNumsFromString(MainTask2.findAvg(mtx))));
        }
}