package by.epam.IntroductionToJava.task4.entity.cargoCarriage;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

import java.util.Objects;

public abstract class BasicCarrier extends Carriage {
        private String productName;
        private double maxLoading; // liters

        public BasicCarrier(short yearOfConstruction, int expensesPerKm, double weightWithoutCargo, String model,
                            TypeOfHook hook, String productName, double maxLoading) {
                super(yearOfConstruction, expensesPerKm, weightWithoutCargo, model, hook);
                this.productName = productName;
                this.maxLoading = maxLoading;
        }

        public String getProductName() {
                return productName;
        }

        public double getMaxLoading() {
                return maxLoading;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n\tProduct name: " + productName +
                        "\n\tMax loadout: " + maxLoading + " kg";
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                BasicCarrier that = (BasicCarrier) o;
                return Double.compare(that.maxLoading, maxLoading) == 0 &&
                        Objects.equals(productName, that.productName);
        }

        @Override
        public int hashCode(){return Integer.parseInt("02" + super.hashCode());}
}
