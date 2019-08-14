package by.epam.IntroductionToJava.task4.reader;

import by.epam.IntroductionToJava.task4.entity.Locomative;
import by.epam.IntroductionToJava.task4.entity.Train;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriageWithCells;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.CargoCarrier;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.LiquidCarrier;
import by.epam.IntroductionToJava.task4.entity.extraCarriage.RestaurantCarriage;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriage;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriageWithRooms;

public class Factory {

        private static short toShort(String s){
                return (short)Integer.parseInt(s);
        }

        private static int toInt(String s){
                return Integer.parseInt(s);
        }

        private static double toDouble(String s) {
                return Double.parseDouble(s);
        }
        private static boolean toBool(String s) {
                return ("+".equals(s));
        }

        private static TypeOfHook toHook(String s) {
                switch (s) {
                        case "A":
                                return TypeOfHook.A;
                        case "B":
                                return TypeOfHook.B;
                        case "C":
                                return TypeOfHook.C;
                        case "D":
                                return TypeOfHook.D;
                        default:
                                return TypeOfHook.I;
                }
        }

        public static Train createTrain (String[][] constructorInstructions) {
                Locomative L = new Locomative(constructorInstructions[0][1],toInt(constructorInstructions[0][2].trim()));
                Train T = new Train(L);

                for (int i = 1; i < constructorInstructions.length; i++) {
                        switch (constructorInstructions[i][0]) {
                                case "010":
                                        T.addCarriage(new BaggageCarriage(
                                                toShort(constructorInstructions[i][1]),
                                                toInt(constructorInstructions[i][2]),
                                                toDouble(constructorInstructions[i][3]),
                                                constructorInstructions[i][4],
                                                toHook(constructorInstructions[i][5]),
                                                toDouble(constructorInstructions[i][6]),
                                                toDouble(constructorInstructions[i][7])
                                                ));
                                        break;
                                case "011":
                                        T.addCarriage(new BaggageCarriageWithCells(
                                                toShort(constructorInstructions[i][1]),
                                                toInt(constructorInstructions[i][2]),
                                                toDouble(constructorInstructions[i][3]),
                                                constructorInstructions[i][4],
                                                toHook(constructorInstructions[i][5]),
                                                toInt(constructorInstructions[i][6]),
                                                toInt(constructorInstructions[i][7]),
                                                toInt(constructorInstructions[i][8])
                                        ));
                                        break;

                                case "020":
                                        T.addCarriage(new CargoCarrier(
                                                toShort(constructorInstructions[i][1]),
                                                toInt(constructorInstructions[i][2]),
                                                toDouble(constructorInstructions[i][3]),
                                                constructorInstructions[i][4],
                                                toHook(constructorInstructions[i][5]),
                                                constructorInstructions[i][6],
                                                toDouble(constructorInstructions[i][7]),
                                                toBool(constructorInstructions[i][8]),
                                                toBool(constructorInstructions[i][9])
                                                ));
                                        break;
                                case "021":
                                        T.addCarriage(new LiquidCarrier(
                                                toShort(constructorInstructions[i][1]),
                                                toInt(constructorInstructions[i][2]),
                                                toDouble(constructorInstructions[i][3]),
                                                constructorInstructions[i][4],
                                                toHook(constructorInstructions[i][5]),
                                                constructorInstructions[i][6],
                                                toDouble(constructorInstructions[i][7]),
                                                toBool(constructorInstructions[i][8]),
                                                toBool(constructorInstructions[i][9])
                                        ));
                                        break;

                                case "030":
                                        T.addCarriage(new RestaurantCarriage(
                                                toShort(constructorInstructions[i][1]),
                                                toInt(constructorInstructions[i][2]),
                                                toDouble(constructorInstructions[i][3]),
                                                constructorInstructions[i][4],
                                                toHook(constructorInstructions[i][5]),
                                                toInt(constructorInstructions[i][6]),
                                                toBool(constructorInstructions[i][7])
                                        ));
                                        break;

                                case "040":
                                        T.addCarriage(new PassangerCarriage(
                                                toShort(constructorInstructions[i][1]),
                                                toInt(constructorInstructions[i][2]),
                                                toDouble(constructorInstructions[i][3]),
                                                constructorInstructions[i][4],
                                                toHook(constructorInstructions[i][5]),
                                                toInt(constructorInstructions[i][6]),
                                                toInt(constructorInstructions[i][7])
                                        ));
                                        break;
                                case "041":
                                        T.addCarriage(new PassangerCarriageWithRooms(
                                                toShort(constructorInstructions[i][1]),
                                                toInt(constructorInstructions[i][2]),
                                                toDouble(constructorInstructions[i][3]),
                                                constructorInstructions[i][4],
                                                toHook(constructorInstructions[i][5]),
                                                toInt(constructorInstructions[i][6]),
                                                toInt(constructorInstructions[i][7]),
                                                toInt(constructorInstructions[i][8])
                                        ));
                                        break;
                        }
                }
                return T;
        }

}
