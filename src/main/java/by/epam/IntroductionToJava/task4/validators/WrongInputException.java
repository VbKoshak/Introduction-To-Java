package by.epam.IntroductionToJava.task4.validators;

public class WrongInputException extends Exception {
        private int line;

        public int getLine() {
                return line;
        }

        public WrongInputException(String message,int line) {
                super(message);
                this.line = line;
        }
}
