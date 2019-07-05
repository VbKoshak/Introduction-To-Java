import java.util.Arrays;

public class task10 {
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
}
