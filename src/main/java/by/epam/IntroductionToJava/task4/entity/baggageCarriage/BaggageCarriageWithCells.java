package by.epam.IntroductionToJava.task4.entity.baggageCarriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

public class BaggageCarriageWithCells extends BaggageCarriage {
        private int numberOfCells;
        private double spacePerCell;       //cubic meters
        private double maxLoadingPerCell;  //kg

        public BaggageCarriageWithCells(short yearOfConstruction, int expensesPerKm, double weightWithoutCargo,
                                        String model, TypeOfHook hook, int numberOfCells, double spacePerCell,
                                        double maxLoadingPerCell) {
                super(yearOfConstruction, expensesPerKm, weightWithoutCargo, model, hook,
                        numberOfCells*spacePerCell, numberOfCells* maxLoadingPerCell);
                this.numberOfCells = numberOfCells;
                this.spacePerCell = spacePerCell;
                this.maxLoadingPerCell = maxLoadingPerCell;
        }

        public int getNumberOfCells() {
                return numberOfCells;
        }

        public double getSpacePerCell() {
                return spacePerCell;
        }

        public double getMaxLoadingPerCell() {
                return maxLoadingPerCell;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                BaggageCarriageWithCells that = (BaggageCarriageWithCells) o;
                return numberOfCells == that.numberOfCells &&
                        spacePerCell == that.spacePerCell &&
                        maxLoadingPerCell == that.maxLoadingPerCell;
        }

        @Override
        public String toString() {
                return super.toString() +
                        "\n\tNumber of cells: " + numberOfCells +
                        "\n\tSpace per cell: " + spacePerCell +
                        "\n\tMax loadout per cell: " + maxLoadingPerCell;
        }
}
