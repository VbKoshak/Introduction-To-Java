package by.epam.IntroductionToJava.task4.validators;

public class constructorInstructionsValidator {

        private static boolean isYear(String s){
                boolean result = true;
                try{
                        int year = Integer.parseInt(s);
                        if (year < 1500 || year > 3000){
                                result = false;
                        }
                } catch(Exception e) {
                        result = false;
                }
                return result;
        }

        private static boolean isInt(String s){
                boolean result = true;
                try{
                        int a = Integer.parseInt(s);
                } catch (Exception ex){
                        result = false;
                }
                return result;
        }

        private static boolean isDouble(String s) {
                boolean result = true;
                try{
                        double d = Double.parseDouble(s);
                } catch(Exception e){
                        result = false;
                }
                return result;
        }

        private static boolean isHook(String s){
                boolean result = true;
                switch(s){
                        case "A":
                        case "B":
                        case "C":
                        case "D":
                                break;
                        default:
                                result = false;
                }
                return result;
        }

        private static boolean isBool(String s){
                return (s.trim().equals("+") || s.trim().equals("-"));
        }

        private static boolean isProperString(String s){
                return (s.length()>0);
        }

        private static boolean checkLocomative(String[] instructionLine){
                boolean result = true;
                try{
                        if (instructionLine[0].length() == 0) {
                                result = false;
                        }
                        int a = Integer.parseInt(instructionLine[2].trim());
                        if (a < 0 || a > 200_000){
                                result = false;
                        }
                } catch (Exception ex){
                        result = false;
                        System.out.println(ex.getMessage());
                }
                return result;
        }

        private static boolean checkCommon(String[] instructionLine){
                boolean result = true;
                if (instructionLine.length < 6){
                        result = false;
                } else {
                        //Wrong input for hook will be replaced with type I, which is special, and will not cause trouble
                        if (!isHook(instructionLine[5])){
                                instructionLine[5] = "I";
                        }
                        result = (isYear(instructionLine[1])
                                && isInt(instructionLine[2])
                                && isDouble(instructionLine[3])
                                && isProperString(instructionLine[4])
                                );
                }
                return result;
        }

        private static boolean checkBaggageCarriages(String[] instructionLine){
                boolean result = true;
                switch(instructionLine[0]){
                        case "010":
                                result = ((instructionLine.length == 8) &&
                                        isDouble(instructionLine[6]) &&
                                        isDouble(instructionLine[7])
                                );
                                break;
                        case "011":
                                result = ((instructionLine.length == 9) &&
                                        isInt(instructionLine[6]) &&
                                        isInt(instructionLine[7]) &&
                                        isInt(instructionLine[8])
                                );
                                break;
                        default:
                                result = false;
                                break;
                }
                return result;
        }

        private static boolean checkCargoCarriages(String[] instructionLine){
                boolean result = true;
                if(instructionLine.length < 8){
                        result =  false;
                } else {
                        if (isProperString(instructionLine[6]) && isDouble(instructionLine[7])){
                                switch (instructionLine[0]){
                                        case "020":
                                        case "021":
                                                result = (instructionLine.length == 10 &&
                                                        isBool(instructionLine[8]) &&
                                                        isBool(instructionLine[9])
                                                        );
                                                break;
                                        default:
                                                result = false;
                                                break;
                                }
                        } else {
                                result = false;
                        }
                }
                return result;
        }

        private static boolean checkExtraCarriages(String[] instructionLine){
                boolean result = true;
                switch(instructionLine[0]){
                        case "030":
                                result = ((instructionLine.length == 8) &&
                                        isInt(instructionLine[6]) &&
                                        isBool(instructionLine[7])
                                );
                                break;
                        default:
                                result = false;
                                break;
                }
                return result;
        }

        private static boolean checkPassangerCarriages(String[] instructionLine){
                boolean result = true;
                switch(instructionLine[0]){
                        case "040":
                                result = ((instructionLine.length == 8) &&
                                        isInt(instructionLine[6]) &&
                                        isInt(instructionLine[7])
                                );
                                break;
                        case "041":
                                result = ((instructionLine.length == 9) &&
                                        isInt(instructionLine[6]) &&
                                        isInt(instructionLine[7]) &&
                                        isInt(instructionLine[8])
                                );
                                break;
                        default:
                                result = false;
                                break;
                }
                return result;
        }

        //TODO add possibility to add some trains in one file
        //as locomative is necessary for building train it throws exceptions unlike carriages that will be just ignored
        public static void checkInstructions(String[][] instructions) throws WrongInputException{
                if(instructions.length == 0){
                        throw new WrongInputException("Instructions can not be empty", 0);
                }
                if(!instructions[0][0].equals("00")){
                        throw new WrongInputException("Instructions should start with creating locomative", 0);
                }
                for (int i = 1; i < instructions.length;i++){
                        if (instructions[i][0].equals("00")) {
                                throw new WrongInputException("One file for one train, one locomative per train", i);
                        }
                }
                if(!checkLocomative(instructions[0])){
                        throw new WrongInputException("Locamative description is not full or incorrect, train can not be build",0);
                }
                for (int i = 1; i < instructions.length; i++){
                        if (checkCommon(instructions[i])) { // check common param's ignoring id
                                boolean canBeRead = false;
                                switch (instructions[i][0]) {
                                        case "010":
                                        case "011":
                                                canBeRead = checkBaggageCarriages(instructions[i]);
                                                break;
                                        case "020":
                                        case "021":
                                                canBeRead = checkCargoCarriages(instructions[i]);
                                                break;
                                        case "030":
                                                canBeRead = checkExtraCarriages(instructions[i]);
                                                break;
                                        case "040":
                                        case "041":
                                                canBeRead = checkPassangerCarriages(instructions[i]);
                                                break;
                                        case "--":
                                                //TODO add logger saying that line is ignored
                                                break;
                                        default:
                                                //TODO add logger saying that id is not recognised and line skiped
                                                break;
                                }
                                //if it can not be scanned we change it's id, not to scan it when creating carriages
                                if (!canBeRead){
                                        instructions[i][0] = "--";
                                }
                        }
                }

        }
}
