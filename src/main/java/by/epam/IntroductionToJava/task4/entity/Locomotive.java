package by.epam.IntroductionToJava.task4.entity;

import java.util.Objects;

public class Locomotive {
        private String model;
        private int power; //horse powers

        public Locomotive(String model, int power) {
                this.model = model;
                this.power = power;
        }
        public Locomotive(){
                this.model = "unknown";
                this.power = 0;
        }

        public String getModel() {
                return model;
        }

        public int getPower() {
                return power;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Locomotive that = (Locomotive) o;
                return power == that.power &&
                        Objects.equals(model, that.model);
        }

        @Override
        public int hashCode() {
                return Integer.parseInt("9" + (model.hashCode() + power)/10);
        }

        @Override
        public String toString() {
                return  "Locomotive" +
                        "\n\tModel: " + model +
                        "\n\tPower: " + power + " hp";
        }
}
