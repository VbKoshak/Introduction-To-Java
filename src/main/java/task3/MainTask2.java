package task3;

import java.util.Arrays;

public class MainTask2 {

        /*
        *найти экстремальные значения (минимальный и максимальный элементы)
        *данной матрицы;
         */

        private static int[] indexOfMaxEl(double[][] mtx) {
               int height = mtx.length;
               int length = mtx[0].length;

               double maxEl = mtx[0][0];
               int[] maxIndex = {0,0};
               for (int i = 0; i < height; i++) {
                       for (int j = 0; j < length; j++) {
                               if (mtx[i][j] > maxEl) {
                                       maxEl = mtx[i][j];
                                       maxIndex[0]=i;
                                       maxIndex[1]=j;
                               }
                       }
               }
               return maxIndex;
        }

        private static int[] indexOfMinEl(double[][] mtx) {
                int height = mtx.length;
                int length = mtx[0].length;

                double minEl = mtx[0][0];
                int[] minIndex = {0,0};
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < length; j++) {
                                if (mtx[i][j] < minEl) {
                                        minEl = mtx[i][j];
                                        minIndex[0]=i;
                                        minIndex[1]=j;
                                }
                        }
                }
                return minIndex;
        }

        public static String findExtrema(double[][] mtx) {
                int[] max = indexOfMaxEl(mtx);
                int[] min = indexOfMinEl(mtx);

                return "Indexes of :\nmax el: " + Arrays.toString(max) + "\nmin el: " + Arrays.toString(min);
        }

        /*
        *найти среднеарифметическое и среднегеометрическое значения всех
        *элементов матрицы;
         */

        private static double arythmAvg(double[][] mtx){
                int height = mtx.length;
                int length = mtx[0].length;

                double sum = 0;
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < length; j++) {
                                sum += mtx[i][j];
                        }
                }

                return sum/(height*length);
        }

        private static double geomAvg(double[][] mtx) {
                int height = mtx.length;
                int length = mtx[0].length;

                double res = 1;
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < length; j++) {
                                res *= mtx[i][j];
                        }
                }

                return Math.pow(res,(double)1/(height*length));
        }

        public static String findAvg(double[][] mtx) {
                String res = "Arythmetic average: " + arythmAvg(mtx) + "\nGeometric average: " + geomAvg(mtx) + " ";
                return res;
        }

        /*
        *проверить, является ли матрица симметричной относительно главной (или
        *побочной) диагонали.
         */


        private static boolean isSymetricMainDiag(double[][] mtx) {
                int size = mtx.length;
                int miniSize = size - 1;
                boolean flag = true;

                for (int i = 0; i < miniSize && flag; i++) {
                        for (int j = i+1; j < size && flag; j++) {
                                if (mtx[i][j] != mtx[j][i]) {
                                        flag = false;
                                }
                        }
                }

                return flag;
        }

        private static boolean isSymetricSecondDiag(double[][] mtx) {
                int miniSize = mtx.length - 1;
                int border;
                boolean flag = true;

                for (int i = 0; i < miniSize && flag; i++) {
                        border = miniSize - i;
                        for (int j = 0; j < border && flag; j++) {
                                if (mtx[j][i] != mtx[miniSize-i][miniSize-j]) {
                                        flag = false;
                                }
                        }
                }

                return flag;
        }

        public static boolean isSymetric (double[][] mtx) {
                return (isSymetricSecondDiag(mtx) || isSymetricMainDiag(mtx));
        }

        /*
        * найти позицию первого встретившегося локального минимума (максимума), а
        *если таких элементов нет, то возвратить (-1;-1) (локальный минимум это
        *элемент, который меньше любого из своих соседей; локальный максимум – это
        *элемент, который больше любого из своих соседей);
        */

        private static boolean isExtrema(double[][] mtx, int i, int j) {
                int height = mtx.length - 1;
                int length = mtx[0].length - 1;

                boolean maxFlag = true;
                boolean minFlag = true;

                if(i != 0) {
                       if (mtx[i][j] > mtx[i-1][j]) {
                               minFlag = false;
                       } else if (mtx[i][j] < mtx[i-1][j]) {
                               maxFlag = false;
                       } else {
                               maxFlag = false;
                               minFlag = false;
                       }
                }

                if (i != height) {
                        if (mtx[i][j] > mtx[i+1][j]) {
                                minFlag = false;
                        } else if (mtx[i][j] < mtx[i+1][j]) {
                                maxFlag = false;
                        } else {
                                maxFlag = false;
                                minFlag = false;
                        }
                }

                if (!(minFlag || maxFlag)){                             // should make the process a little faster
                        return false;
                }

                if(j != 0) {
                        if (mtx[i][j] > mtx[i][j-1]) {
                                minFlag = false;
                        } else if (mtx[i][j] < mtx[i][j-1]) {
                                maxFlag = false;
                        } else {
                                maxFlag = false;
                                minFlag = false;
                        }
                }

                if (j != length) {
                        if (mtx[i][j] > mtx[i][j+1]) {
                                minFlag = false;
                        } else if (mtx[i][j] < mtx[i][j+1]) {
                                maxFlag = false;
                        } else {
                                maxFlag = false;
                                minFlag = false;
                        }
                }

                return (minFlag || maxFlag);
        }

        public static int[] findIndexOfLocalExtrema(double[][] mtx) {
                int height = mtx.length;
                int length = mtx[0].length;
                int[] res = {-1,-1};
                boolean flag = true;

                for (int i = 0; i < height && flag; i++) {
                        for (int j = 0; j < length && flag; j++) {
                                if (isExtrema(mtx,i,j)) {
                                        res[0] = i;
                                        res[1] = j;
                                        flag = false;
                                }
                        }
                }

                return res;
        }

        /*
        * транспонировать квадратную матрицу (при решении данного задания не
        *рекомендуется задействовать дополнительную память для дополнительного
        *массива).
         */

        private static void swapMtx(double[][] mtx, int i_1, int j_1, int i_2, int j_2) {
                mtx[i_1][j_1] += mtx[i_2][j_2];
                mtx[i_2][j_2] = mtx[i_1][j_1] - mtx[i_2][j_2];
                mtx[i_1][j_1] -= mtx[i_2][j_2];
        }

        public static void matrixTransposition(double[][] mtx) {                // так как дополнительную память выделять
                int length = mtx.length;                                        // нельзя, то работаем только с квадратными

                for (int i = 0; i < length; i++) {
                        for (int j = i+1; j < length; j++) {
                                swapMtx(mtx,i,j,j,i);
                        }
                }
        }
}
