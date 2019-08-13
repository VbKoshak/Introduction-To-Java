package by.epam.IntroductionToJava.task4.entity.passangerCarriage;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class BasicPassangerCarriage extends Carriage {
        private int totalNumberOfPlaces;
        private int pricePerPlace;

        public BasicPassangerCarriage(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo,
                                      String model, TypeOfHook hook, int totalNumberOfPlaces, int pricePerPlace) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, model, hook);
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
                BasicPassangerCarriage that = (BasicPassangerCarriage) o;
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
