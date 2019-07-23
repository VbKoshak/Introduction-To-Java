package task1;

import java.util.Arrays;

public class MainTask2 {

        //////////////////////////////////////////////////////////

        private static double calcLength(int[] a, int[] b) {
                double xDif = Math.abs(a[0] - b[0]);
                double yDif = Math.abs(a[1] - b[1]);

                return Math.sqrt(Math.pow(xDif,2)+Math.pow(yDif,2));
        }

        private static boolean isTriangle(double len1, double len2, double len3) {
                boolean condition1 = len1 + len2 > len3;
                boolean condition2 = len1 + len3 > len2;
                boolean condition3 = len3 + len2 > len1;
                if (condition1 && condition2 && condition3) {
                        return true;
                } else {
                        return false;
                }
        }

        private static boolean isRightTriangle(double len1, double len2, double len3) {
                len1 = Math.pow(len1,2);
                len2 = Math.pow(len2,2);
                len3 = Math.pow(len3,2);

                boolean condition1 = (len1 + len2 == len3);
                boolean condition2 = (len3 + len2 == len1);
                boolean condition3 = (len1 + len3 == len2);

                if (condition1 || condition2 || condition3) {
                        return true;
                } else {
                        return false;
                }
        }

        public static boolean checkTriangle(int[] a, int[] b, int[] c){
                double  len1,
                        len2,
                        len3;

                len1 = calcLength(a,b);
                len2 = calcLength(a,c);
                len3 = calcLength(b,c);

                if (!isTriangle(len1,len2,len3)) {
                        return false;
                } else {
                        if (isRightTriangle(len1,len2,len3)) {
                                System.out.println("Triangle is right!");
                        }
                        return true;
                }
        }

        ///////////////////////////////////////////////////////

        public static int dragonHeads(int age){
                int heads = 3;          //initial value

                if (age < 200) {
                        heads += 3* age;
                } else {
                        heads += 3 * 199;
                        if (age < 300) {
                                heads += 2 * ( age - 199);
                        } else {
                                heads += 2 * 100;
                                if (age >= 300) {
                                        heads += (age - 299);
                                }
                        }
                }

                return heads;
        }

        //////////////////////////////////////////////////////////////

        public static boolean characterCheck(char c) {
                c = Character.toUpperCase(c);
                int cNum = Character.getNumericValue(c);
                int[] trueChars = {10, 14, 18, 24, 30, 34};
                if (Arrays.binarySearch(trueChars,cNum) >= 0) { return true; }
                return false;
        }

        public static boolean characterCheck2(char c) {
                char[] trueChars = {'e', 'E', 'y', 'Y', 'u', 'U', 'i', 'I', 'o' ,'O', 'a','A'};
                boolean result = false;
                for (int i = 0; i < trueChars.length; i++) {
                        if (trueChars[i] == c) {
                                result = true;
                        }
                }
                return result;
        }

        /////////////////////////////////////////////////////////////////////

        private static boolean isLeap(int y){
                if (y % 400 == 0){
                        return true;
                } else if (y % 100 == 0) {
                        return false;
                } else if (y % 4 == 0) {
                        return true;
                } else {
                        return false;
                }
        }

        public static String nextDay(int d, int m, int y) {
                short[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

                if(isLeap(y)) {
                        daysInMonths[1] ++;
                }

                if (d < daysInMonths[m-1]){
                        return "" + (d + 1) + "." + m + "." + y;
                } else {
                        if (m < 12) {
                                return "1." + (m + 1) + "." + y;
                        } else {
                                return "1.1." + (y+1);
                        }
                }
        }
}
