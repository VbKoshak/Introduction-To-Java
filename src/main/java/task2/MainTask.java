package task2;

import java.util.Random;

public class MainTask {
        /*
        *       Необходимо написать программу «Heads or Tails?» («Орёл или решка?»),
        *       которая бы «подбрасывала» условно монету, к примеру, 1000 раз и сообщала,
        *       сколько раз выпал орёл, а сколько – решка.        *
         */
        public static String headsOrTails(int times) {
                if (times <= 0) {
                        return "0";
                }

                final Random random = new Random();
                boolean coin;
                int headCount = 0;
                for (int i = 0; i < times; i++) {
                        coin = random.nextBoolean();
                        if (coin) {
                                headCount++;
                        }
                }
                return "Heads: " + headCount + "\nTails: " + (times - headCount);
        }
        /*
        *Разработать наиболее эффективные алгоритмы и написать код для решения
        *следующих задач:
        *         найти наибольшую цифру натурального числа;
        *         проверить, является ли заданное натуральное число палиндромом;
        *         определить является ли заданное натуральное число простым;
        *         найти все простые делители заданного натурального числа;
        *         найти НОД и НОК двух натуральных чисел a и b.
        *         найти количество различных цифр у заданного натурального числа.
         */
        public static int biggestNumeral(long num) {
                if (num <= 0) {
                        return 0;
                }
                int biggest = 0;
                do {
                        if (num % 10 > biggest) {
                                biggest = (int)(num % 10);
                        }
                        num /= 10;
                } while (num > 0);
                return biggest;
        }

        public static boolean isPalindrome (int in) {
                String num = "" + in;
                int length = num.length();
                int halfLength = length/2;
                for (int i = 0; i < halfLength;) {
                        if (num.charAt(i) != num.charAt(length-++i)) {
                                return false;
                        }
                }
                return true;
        }

        public static boolean isPrime (int in) {
                if (in < 2 || in % 2 == 0) {
                        return false;
                }
                int maxDivisor = in / 2;
                for (int i = 3; i < maxDivisor; i+=2) {
                        if (in % i == 0) {
                                return false;
                        }
                }
                return true;
        }

        public static String commmonDivisors (int in) {
                if (in <= 0) {
                        return "0";
                }
                String result = "";

                int max = in/2;
                int divisor = 2;

                while (divisor <= max && in != 0) {
                        if (in % divisor == 0) {
                                result += divisor + " ";
                                in /= divisor;
                        } else {
                                divisor++;
                        }
                }

                return result;
        }

        public static String LCMandGCD (int a, int b) {
                if (a == b) {
                        return "Numbers should not be equal!";
                } else  if (a == 1 || b == 1 || a == 0 || b == 0){
                        return "Numbers should not be 0 or 1!0";
                }
                int GCD;
                int LCM;

                int firstNumber = a;
                int secondNumber = b;

                do {
                        if (firstNumber > secondNumber) {
                                firstNumber -= secondNumber;
                        } else {
                                secondNumber -= firstNumber;
                        }
                } while (firstNumber != secondNumber);

                GCD = firstNumber;
                LCM = a*b/GCD;

                return "GCD: " + GCD + "\nLCM: " + LCM;
        }

        public static int uniqueNumbers (int in) {
                String inputNumber = "" + in;
                int count = 0;
                for (int i = 0; i < 10; i++) { // 9 nums
                        if (inputNumber.indexOf(""+i) != -1) {
                                count++;
                        }
                }
                return count;
        }

        /*
        *Натуральное число называют совершенным, если оно равно сумме всех своих
        *делителей, не считая только его самого (например, 28=1+2+3+7+14 –
        *совершенное число). Напишите программу, которая проверяет, является ли
        *введённое натуральное число совершенным. Для проверки работоспособности
        *программы приводится список некоторых совершенных чисел: 6, 28, 496, 8128.
         */


        public static int divisorsSum (int in) {

                int maxDivisor = in/2;
                int counter = 0;

                for (int i = 1;i <= maxDivisor; i++) {
                        if (in % i == 0) {
                                counter += i;
                        }
                }

                return counter;

        }

        public static boolean isPerfectNumber(int in) {

                int divisorsSum = divisorsSum(in);

                if (divisorsSum == in) {
                        return true;
                } else {
                        return false;
                }
        }

        /*
         *Дру́жественные чи́сла — два различных натуральных числа , для которых
         *сумма всех собственных делителей первого числа равна второму числу и
         *наоборот, сумма всех собственных делителей второго числа равна первому
         *числу. Дружественные числа были открыты последователями Пифагора ,
         *которые, однако, знали только одну пару дружественных чисел – 220 и 284.
         *Найдите все дружественные числа в заданном диапазоне.
         */

        public static String findFriendlyNumbers (int intervalBegin, int intervalEnd) {
                if (intervalBegin >= intervalEnd || intervalEnd < 0) {
                        return "Wrong input!";
                }

                int divSum;
                String resultStr = "";

                for (int i = intervalBegin; i <= intervalEnd; i++) {
                        divSum = divisorsSum(i);
                        if (divSum < i && divisorsSum(divSum) == i) {
                                resultStr += divSum + " & " + i + " ; ";
                        }
                }

                return resultStr;
        }

        public static void main (String[] args) {
                System.out.println(biggestNumeral(57842359));
                System.out.println(isPalindrome(153321));
                System.out.println(isPrime(863));
                System.out.println(commmonDivisors(75));
                System.out.println(LCMandGCD(15,10));
                System.out.println(uniqueNumbers(456587));
                System.out.println(isPerfectNumber(8129));
                System.out.println(findFriendlyNumbers(1,100000));
        }

}
