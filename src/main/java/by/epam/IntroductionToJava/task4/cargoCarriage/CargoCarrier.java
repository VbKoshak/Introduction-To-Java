package by.epam.IntroductionToJava.task4.cargoCarriage;

import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class CargoCarrier extends BasicCarrier {
        private boolean isCovered;
        private boolean hasWalls;

        public CargoCarrier(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id,
                            String model, TypeOfHook hook, String productName, double maxLoadout, boolean isCovered,
                            boolean hasWalls) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook, productName, maxLoadout);
                this.isCovered = isCovered;
                this.hasWalls = hasWalls;
        }

        public boolean isCovered() {
                return isCovered;
        }

        public boolean hasWalls() {
                return hasWalls;
        }
}
