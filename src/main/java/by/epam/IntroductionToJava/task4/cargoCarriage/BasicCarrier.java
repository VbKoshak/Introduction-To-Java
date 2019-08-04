package by.epam.IntroductionToJava.task4.cargoCarriage;

import by.epam.IntroductionToJava.task4.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class BasicCarrier extends Carriage {
        private String productName;
        private double maxLoadout; // liters

        public BasicCarrier(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id, String model, TypeOfHook hook, String productName, double maxLoadout) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook);
                this.productName = productName;
                this.maxLoadout = maxLoadout;
        }

        public String getProductName() {
                return productName;
        }

        public double getMaxLoadout() {
                return maxLoadout;
        }
}
