package by.epam.IntroductionToJava.task4.entity.passangerCarriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class PassangerCarriageWithRooms extends BasicPassangerCarriage {
        private int numberOfRooms;
        private int placesPerRoom;
        private final String className = "Comfortable passenger carriage";

        public PassangerCarriageWithRooms(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, String model, TypeOfHook hook,
                                          int pricePerPlace, int numberOfRooms, int placesPerRoom) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, model, hook, numberOfRooms*placesPerRoom, pricePerPlace);
                this.numberOfRooms = numberOfRooms;
                this.placesPerRoom = placesPerRoom;
        }

        public int getNumberOfRooms() {
                return numberOfRooms;
        }

        public int getPlacesPerRoom() {
                return placesPerRoom;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                PassangerCarriageWithRooms that = (PassangerCarriageWithRooms) o;
                return numberOfRooms == that.numberOfRooms &&
                        placesPerRoom == that.placesPerRoom;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\nNumber of rooms: " + numberOfRooms +
                        "\nPlaces per room: " + placesPerRoom;
        }
}
