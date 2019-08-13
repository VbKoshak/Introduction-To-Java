package by.epam.IntroductionToJava.task4.validators;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriageWithCells;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BasicBaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.BasicCarrier;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.CargoCarrier;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.LiquidCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.BasicPassangerCarriage;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriageWithRooms;

public class InstanceValidator {
        public static boolean hasPlaceForCargo(Carriage car){
                if(car instanceof BasicCarrier || car instanceof CargoCarrier || car instanceof LiquidCarrier){
                        return true;
                } else {
                        return false;
                }
        }

        public static boolean hasPlacesForPassangers(Carriage car) {
                if (car instanceof BasicPassangerCarriage || car instanceof PassangerCarriageWithRooms) {
                        return true;
                } else {
                        return false;
                }
        }

        public static boolean hasPlacesForBaggage(Carriage car) {
                if (car instanceof BaggageCarriageWithCells || car instanceof BasicBaggageCarriage) {
                        return true;
                } else {
                        return false;
                }
        }
}
