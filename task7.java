public class task7 {

        public static void swap(int[] in) {
                in[0] += in[1];
                in[1] = in[0]-in[1];
                in[0] -= in[1];
        }
}
