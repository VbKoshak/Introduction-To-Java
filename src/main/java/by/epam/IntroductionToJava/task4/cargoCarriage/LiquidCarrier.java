package by.epam.IntroductionToJava.task4.cargoCarriage;

import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class LiquidCarrier extends BasicCarrier {
        private boolean isExplosive;
        private boolean isRefregerated;

        public LiquidCarrier(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id,
                             String model, TypeOfHook hook, String productName, double maxLoadout, boolean isExplosive,
                             boolean isRefregerated) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook, productName, maxLoadout);
                this.isExplosive = isExplosive;
                this.isRefregerated = isRefregerated;
        }

        public boolean isExplosive() {
                return isExplosive;
        }

        public boolean isRefregerated() {
                return isRefregerated;
        }
}
