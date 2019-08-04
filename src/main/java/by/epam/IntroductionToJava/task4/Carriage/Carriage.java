package by.epam.IntroductionToJava.task4.Carriage;

public class Carriage {
        private short yearOfConstruction;
        private int expencesPerKm;
        private double weightWithoutCargo;
        private int id;
        private String model;
        private TypeOfHook hook;

        public Carriage(short yearOfConstruction, int expencesPerKm, double weightWithoutCargo, int id, String model, TypeOfHook hook) {
                this.yearOfConstruction = yearOfConstruction;
                this.expencesPerKm = expencesPerKm;
                this.weightWithoutCargo = weightWithoutCargo;
                this.id = id;
                this.model = model;
                this.hook = hook;
        }

        public short getYearOfConstruction() {
                return yearOfConstruction;
        }

        public int getExpencesPerKm() {
                return expencesPerKm;
        }

        public double getWeightWithoutCargo() {
                return weightWithoutCargo;
        }

        public int getId() {
                return id;
        }

        public String getModel() {
                return model;
        }
}
