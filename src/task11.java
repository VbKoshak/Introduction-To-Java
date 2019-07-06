public class task11 {


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
