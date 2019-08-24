package by.epam.IntroductionToJava.task4.entity.Carriage;

import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;

import java.util.Objects;

public abstract class Carriage {
        private short yearOfConstruction;
        private int expensesPerKm;
        private double weightWithoutCargo; // kg
        private int id;                    //given by the program, can not be set
        private String model;
        private TypeOfHook hook;

        private static int count;

        static {
                count  = 1;
        }

        public Carriage(short yearOfConstruction, int expensesPerKm, double weightWithoutCargo, String model, TypeOfHook hook) {
                this.yearOfConstruction = yearOfConstruction;
                this.expensesPerKm = expensesPerKm;
                this.weightWithoutCargo = weightWithoutCargo;
                this.model = model;
                this.hook = hook;
                this.id = count++;
        }

        public short getYearOfConstruction() {
                return yearOfConstruction;
        }

        public int getExpensesPerKm() {
                return expensesPerKm;
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

        public TypeOfHook getHook() {
                return hook;
        }


        @Override
        public String toString() {
                return  "\nIdentification" +
                        "\n\tId: " + id +
                        "\n\tModel: " + model +
                        "\nCharacteristics" +
                        "\n\tYear of construction: " + yearOfConstruction +
                        "\n\tExpenses\\Km: " + expensesPerKm +
                        "\n\tWeight without cargo: "  + weightWithoutCargo + " kg" +
                        "\n\tType of hook: " + hook;
        }

        @Override
        public int hashCode(){
                return Integer.parseInt(Integer.toString(id) + model.hashCode()/100);
        }

        //Returns true not only for the same carriages, but also with the same characteristics (e.g. not comparing id
        //and year of production)
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Carriage carriage = (Carriage) o;
                return expensesPerKm == carriage.expensesPerKm &&
                        Double.compare(carriage.weightWithoutCargo, weightWithoutCargo) == 0 &&
                        Objects.equals(model, carriage.model) &&
                        hook == carriage.hook;
        }
}
