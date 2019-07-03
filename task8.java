public class task8 {

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
}
