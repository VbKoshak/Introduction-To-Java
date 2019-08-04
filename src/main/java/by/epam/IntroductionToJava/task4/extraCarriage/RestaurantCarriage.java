package by.epam.IntroductionToJava.task4.extraCarriage;

import by.epam.IntroductionToJava.task4.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class RestaurantCarriage extends Carriage {
        private int numberOfSeats;
        private boolean hasBar;

        public RestaurantCarriage(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id,
                                  String model, TypeOfHook hook, int numberOfSeats, boolean hasBar) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook);
                this.numberOfSeats = numberOfSeats;
                this.hasBar = hasBar;
        }

        public int getNumberOfSeats() {
                return numberOfSeats;
        }

        public boolean isHasBar() {
                return hasBar;
        }
}
