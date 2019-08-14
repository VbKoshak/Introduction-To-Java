package by.epam.IntroductionToJava.task4.validators;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.BasicCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriage;

public class InstanceValidator {
        public static boolean hasPlaceForCargo(Carriage car){
                return (car instanceof BasicCarrier);
        }

        public static boolean hasPlacesForPassangers(Carriage car) {
                return (car instanceof PassangerCarriage);
        }

        public static boolean hasPlacesForBaggage(Carriage car) {
                return (car instanceof BaggageCarriage);
        }
}
