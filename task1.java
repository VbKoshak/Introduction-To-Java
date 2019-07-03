public class task1 {
        public static boolean differ(int a, int b, int c) {
                return (a == b) ? false
                                : (a == c) ? false
                                           : (b == c) ? false
                                                      : true;
        }
}
