public class task4 {
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
}
