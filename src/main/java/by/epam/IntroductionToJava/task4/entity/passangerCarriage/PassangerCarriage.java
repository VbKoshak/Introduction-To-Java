package by.epam.IntroductionToJava.task4.entity.passangerCarriage;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class PassangerCarriage extends Carriage {
        private int totalNumberOfPlaces;
        private int pricePerPlace;

        public PassangerCarriage(short yearOfConstruction, int expensesPerKm, double weightWithoutCargo,
                                 String model, TypeOfHook hook, int totalNumberOfPlaces, int pricePerPlace) {
                super(yearOfConstruction, expensesPerKm, weightWithoutCargo, model, hook);
                this.totalNumberOfPlaces = totalNumberOfPlaces;
                this.pricePerPlace = pricePerPlace;
        }

        public int countMaxIncome() {
                return this.pricePerPlace * this.totalNumberOfPlaces;
        }

        public int getTotalNumberOfPlaces() {
                return totalNumberOfPlaces;
        }

        public int getPricePerPlace() {
                return pricePerPlace;
        }

        @Override
        public int hashCode(){return Integer.parseInt("04" + super.hashCode());}

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                PassangerCarriage that = (PassangerCarriage) o;
                return totalNumberOfPlaces == that.totalNumberOfPlaces &&
                        pricePerPlace == that.pricePerPlace;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n\tTotal number of places: " + totalNumberOfPlaces +
                        "\n\tPrice per place: " + pricePerPlace;
        }
}
