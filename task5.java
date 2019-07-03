public class task5 {
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
}
