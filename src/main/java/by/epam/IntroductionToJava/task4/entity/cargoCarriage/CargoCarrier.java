package by.epam.IntroductionToJava.task4.entity.cargoCarriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class CargoCarrier extends BasicCarrier {
        private boolean isCovered;
        private boolean hasWalls;

        public CargoCarrier(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo,
                            String model, TypeOfHook hook, String productName, double maxLoadout, boolean isCovered,
                            boolean hasWalls) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, model, hook, productName, maxLoadout);
                this.isCovered = isCovered;
                this.hasWalls = hasWalls;
        }

        public boolean isCovered() {
                return isCovered;
        }

        public boolean hasWalls() {
                return hasWalls;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                CargoCarrier that = (CargoCarrier) o;
                return isCovered == that.isCovered &&
                        hasWalls == that.hasWalls;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n" + (isCovered ? "Covered":"Not covered") +
                        "\n" + (hasWalls ? "Has walls":"No walls");
        }
}
