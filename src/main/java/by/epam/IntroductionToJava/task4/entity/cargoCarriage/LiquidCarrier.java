package by.epam.IntroductionToJava.task4.entity.cargoCarriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class LiquidCarrier extends BasicCarrier {
        private boolean isExplosive;
        private boolean isRefrigerated;

        public LiquidCarrier(short yearOfConstruction, int expensesPerKm, double weightWithoutCargo,
                             String model, TypeOfHook hook, String productName, double maxLoading, boolean isExplosive,
                             boolean isRefrigerated) {
                super(yearOfConstruction, expensesPerKm, weightWithoutCargo, model, hook, productName, maxLoading);
                this.isExplosive = isExplosive;
                this.isRefrigerated = isRefrigerated;
        }

        public boolean isExplosive() {
                return isExplosive;
        }

        public boolean isRefrigerated() {
                return isRefrigerated;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                LiquidCarrier that = (LiquidCarrier) o;
                return isExplosive == that.isExplosive &&
                        isRefrigerated == that.isRefrigerated;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n\t" + (isExplosive ? "Explosive":"Not explosive") +
                        "\n\t" + (isRefrigerated ? "Refrigerated": "Not refrigerated");
        }
}
