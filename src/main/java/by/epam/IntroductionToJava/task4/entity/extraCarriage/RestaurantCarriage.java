package by.epam.IntroductionToJava.task4.entity.extraCarriage;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class RestaurantCarriage extends Carriage {
        private int numberOfSeats;
        private boolean hasBar;

        public RestaurantCarriage(short yearOfConstruction, int expensesPerKm, double weightWithoutCargo,
                                  String model, TypeOfHook hook, int numberOfSeats, boolean hasBar) {
                super(yearOfConstruction, expensesPerKm, weightWithoutCargo, model, hook);
                this.numberOfSeats = numberOfSeats;
                this.hasBar = hasBar;
        }

        public int getNumberOfSeats() {
                return numberOfSeats;
        }

        public boolean HasBar() {
                return hasBar;
        }

        @Override
        public int hashCode(){return Integer.parseInt("03" + super.hashCode());}

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                RestaurantCarriage that = (RestaurantCarriage) o;
                return numberOfSeats == that.numberOfSeats &&
                        hasBar == that.hasBar;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n\tNumber of seats: " + numberOfSeats +
                        "\n\t" + (hasBar ? "Has bar" : "Do not have bar");
        }
}
