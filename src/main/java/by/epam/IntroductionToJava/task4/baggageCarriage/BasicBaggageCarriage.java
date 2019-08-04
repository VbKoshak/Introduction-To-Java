package by.epam.IntroductionToJava.task4.baggageCarriage;

import by.epam.IntroductionToJava.task4.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class BasicBaggageCarriage extends Carriage {
        private double spaceForBaggage; // cubic meters
        private double maxLoadout;      // kg

        public BasicBaggageCarriage(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id,
                                    String model, TypeOfHook hook, double spaceForBaggage, double maxLoadout) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook);
                this.spaceForBaggage = spaceForBaggage;
                this.maxLoadout = maxLoadout;
        }

        public double getSpaceForBaggage() {
                return spaceForBaggage;
        }

        public double getMaxLoadout() {
                return maxLoadout;
        }
}
