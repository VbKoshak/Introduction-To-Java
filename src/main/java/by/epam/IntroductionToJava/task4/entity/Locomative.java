package by.epam.IntroductionToJava.task4.entity;

import java.util.Objects;

public class Locomative {
        private String model;
        private int power; //horse powers

        public String getModel() {
                return model;
        }

        public int getPower() {
                return power;
        }

        public Locomative(String model, int power) {
                this.model = model;
                this.power = power;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Locomative that = (Locomative) o;
                return power == that.power &&
                        Objects.equals(model, that.model);
        }

        @Override
        public int hashCode() {
                return model.hashCode() + power;
        }

        @Override
        public String toString() {
                return "--------------------------\n\n" +
                        "--\tLocomative\t--" +
                        "\nModel: " + model +
                        "\nPower: " + power + " hp";
        }
}
