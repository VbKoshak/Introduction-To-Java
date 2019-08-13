package by.epam.IntroductionToJava.task4.entity.cargoCarriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class LiquidCarrier extends BasicCarrier {
        private boolean isExplosive;
        private boolean isRefregerated;

        public LiquidCarrier(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo,
                             String model, TypeOfHook hook, String productName, double maxLoadout, boolean isExplosive,
                             boolean isRefregerated) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, model, hook, productName, maxLoadout);
                this.isExplosive = isExplosive;
                this.isRefregerated = isRefregerated;
        }

        public boolean isExplosive() {
                return isExplosive;
        }

        public boolean isRefregerated() {
                return isRefregerated;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                LiquidCarrier that = (LiquidCarrier) o;
                return isExplosive == that.isExplosive &&
                        isRefregerated == that.isRefregerated;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n\t" + (isExplosive ? "Explosive":"Not explosive") +
                        "\n\t" + (isRefregerated ? "Refregerated": "Not refregerated");
        }
}
