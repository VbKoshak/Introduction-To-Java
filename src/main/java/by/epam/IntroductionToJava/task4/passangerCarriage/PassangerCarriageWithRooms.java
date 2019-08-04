package by.epam.IntroductionToJava.task4.passangerCarriage;

import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class PassangerCarriageWithRooms extends BasicPassangerCarriage {
        private int numberOfRooms;
        private int placesPerRoom;

        public PassangerCarriageWithRooms(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo,
                                          int id, String model, TypeOfHook hook,
                                          int pricePerPlace, int numberOfRooms, int placesPerRoom) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook, numberOfRooms*placesPerRoom, pricePerPlace);
                this.numberOfRooms = numberOfRooms;
                this.placesPerRoom = placesPerRoom;
        }

        public int getNumberOfRooms() {
                return numberOfRooms;
        }

        public int getPlacesPerRoom() {
                return placesPerRoom;
        }
}
