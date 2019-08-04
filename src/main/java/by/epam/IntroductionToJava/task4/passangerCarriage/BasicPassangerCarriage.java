package by.epam.IntroductionToJava.task4.passangerCarriage;

import by.epam.IntroductionToJava.task4.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class BasicPassangerCarriage extends Carriage {
        private int totalNumberOfPlaces;
        private int pricePerPlace;

        public BasicPassangerCarriage(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id,
                                      String model, TypeOfHook hook, int totalNumberOfPlaces, int pricePerPlace) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook);
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
}
