package by.epam.IntroductionToJava.task4.baggageCarriage;

import by.epam.IntroductionToJava.task4.Carriage.TypeOfHook;

public class BaggageCarriageWithCells extends BasicBaggageCarriage {
        private int numberOfCells;
        private int spacePerCell;
        private int maxLoadoutPerCell;

        public BaggageCarriageWithCells(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id,
                                        String model, TypeOfHook hook, int numberOfCells, int spacePerCell,
                                        int maxLoadoutPerCell) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, id, model, hook,
                        numberOfCells*spacePerCell, numberOfCells*maxLoadoutPerCell);
                this.numberOfCells = numberOfCells;
                this.spacePerCell = spacePerCell;
                this.maxLoadoutPerCell = maxLoadoutPerCell;
        }

        public int getNumberOfCells() {
                return numberOfCells;
        }

        public int getSpacePerCell() {
                return spacePerCell;
        }

        public int getMaxLoadoutPerCell() {
                return maxLoadoutPerCell;
        }
}
