package by.epam.IntroductionToJava.task4.entity.baggageCarriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class BaggageCarriageWithCells extends BaggageCarriage {
        private int numberOfCells;
        private double spacePerCell;       //cubic meters
        private double maxLoadoutPerCell;  //kg

        public BaggageCarriageWithCells(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo,
                                        String model, TypeOfHook hook, int numberOfCells, double spacePerCell,
                                        double maxLoadoutPerCell) {
                super(yearOfConstruction, expencesPerKm, weightWithoutCargo, model, hook,
                        numberOfCells*spacePerCell, numberOfCells*maxLoadoutPerCell);
                this.numberOfCells = numberOfCells;
                this.spacePerCell = spacePerCell;
                this.maxLoadoutPerCell = maxLoadoutPerCell;
        }

        public int getNumberOfCells() {
                return numberOfCells;
        }

        public double getSpacePerCell() {
                return spacePerCell;
        }

        public double getMaxLoadoutPerCell() {
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
                        "\n\tNumber of cells: " + numberOfCells +
                        "\n\tSpace per cell: " + spacePerCell +
                        "\n\tMax loadout per cell: " + maxLoadoutPerCell;
        }
}
