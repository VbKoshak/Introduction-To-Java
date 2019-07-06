public class task6 {
        public static int reverse(int in) {
                int out = 0;
                int length = (""+in).length();
                for (int i = 0; i < length; i++) {
                        out += (int)(in / Math.pow(10,i)) % 10;
                        out *= 10;
                }
                return out/10;
        }
}
