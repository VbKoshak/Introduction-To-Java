package by.epam.IntroductionToJava.task4.validators;

public class WrongInputException extends Exception {
        private int line;
        private String type;

        public int getLine() {
                return line;
        }

        public String getType() {
                return type;
        }

        public WrongInputException(String message, int line) {
                super(message);
                this.line = line;
        }

        public WrongInputException(String message, int line, String type){
                super(message);
                this.line = line;
                this.type = type;
        }
}
