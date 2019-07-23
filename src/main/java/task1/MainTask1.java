package task1;

import static java.lang.Double.NaN;

public class MainTask1 {

        public static boolean differ(int a, int b, int c) {
                return (a == b) ? false
                        : (a == c) ? false
                        : (b == c) ? false
                        : true;
        }

        public static void showFromKilos (double kg) {
                double mg = kg * 1e6;
                double gr = kg * 1e3;
                double t = kg * 1e-3;
                System.out.println("Milligrams: " + String.format("%f", mg));
                System.out.println("Grams: " + String.format("%f", gr));
                System.out.println("Tons: " + String.format("%f", t));
        }

        public static double ringSquare(int R1, int R2){
                if (R2 >= R1){
                        return NaN;
                }
                return (Math.PI*Math.pow(R1,2)) - (Math.PI*Math.pow(R2,2));
        }

        public static boolean isGrowing(int in) {
                int firstNumber = in % 10;         // 4th number
                int secondNumber = (in/10)%10;     // 3rd number
                if (secondNumber >= firstNumber) { // compare last 2 numbers
                        return false;
                }
                firstNumber = (in/100)%10;         // 2nd number
                if (firstNumber >= secondNumber) {
                        return false;
                }
                secondNumber  = in/1000;           // 1st number
                if (secondNumber >= firstNumber) {
                        return false;
                }
                return true;
        }

        public static void findNumberAverages(int in){
                float length = (""+in).length();
                int number;
                double arithmAvg = 0;
                double geomAvg = 1;

                for (int i = 0; i < length; i++) {
                        number = (int)(in / Math.pow(10,i)) % 10;
                        arithmAvg += number;
                        geomAvg *= number;
                }

                arithmAvg /= length;
                geomAvg = Math.pow(geomAvg, 1/length);

                System.out.println("Arithmetic average: " + arithmAvg);
                System.out.println("Geometric average: " + geomAvg);
        }

        public static int reverse(int in) {
                int out = 0;
                int length = (""+in).length();
                for (int i = 0; i < length; i++) {
                        out += (int)(in / Math.pow(10,i)) % 10;
                        out *= 10;
                }
                return out/10;
        }

        public static void swap(int[] in) {
                in[0] += in[1];
                in[1] = in[0]-in[1];
                in[0] -= in[1];
        }
}
