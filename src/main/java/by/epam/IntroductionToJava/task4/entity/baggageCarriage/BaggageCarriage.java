package by.epam.IntroductionToJava.task4.entity.baggageCarriage;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class BaggageCarriage extends Carriage {
        private double spaceForBaggage; // cubic meters
        private double maxLoading;      // kg

        public BaggageCarriage(short yearOfConstruction, int expensesPerKm, double weightWithoutCargo,
                               String model, TypeOfHook hook, double spaceForBaggage, double maxLoading) {
                super(yearOfConstruction, expensesPerKm, weightWithoutCargo, model, hook);
                this.spaceForBaggage = spaceForBaggage;
                this.maxLoading = maxLoading;
        }

        public double getSpaceForBaggage() {
                return spaceForBaggage;
        }

        public double getMaxLoading() {
                return maxLoading;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                BaggageCarriage that = (BaggageCarriage) o;
                return Double.compare(that.spaceForBaggage, spaceForBaggage) == 0 &&
                        Double.compare(that.maxLoading, maxLoading) == 0;
        }

        @Override
        public int hashCode() {
                return Integer.parseInt("03" + super.hashCode());
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n\tSpaceForBaggage: " + spaceForBaggage +
                        "\n\tMaxLoading: " + maxLoading;
        }
}
