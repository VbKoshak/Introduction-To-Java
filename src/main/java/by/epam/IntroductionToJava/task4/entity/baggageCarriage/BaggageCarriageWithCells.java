package by.epam.IntroductionToJava.task4.entity.baggageCarriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class BaggageCarriageWithCells extends BasicBaggageCarriage {
        private int numberOfCells;
        private int spacePerCell;
        private int maxLoadoutPerCell;
        private final String className = "Celled baggage carriage";

        public BaggageCarriageWithCells(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo,
                                        String model, TypeOfHook hook, int numberOfCells, int spacePerCell,
                                        int maxLoadoutPerCell) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, model, hook,
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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                BaggageCarriageWithCells that = (BaggageCarriageWithCells) o;
                return numberOfCells == that.numberOfCells &&
                        spacePerCell == that.spacePerCell &&
                        maxLoadoutPerCell == that.maxLoadoutPerCell;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\nNumber of cells: " + numberOfCells +
                        "\nSpace per cell: " + spacePerCell +
                        "\nMax loadout per cell: " + maxLoadoutPerCell;
        }
}
