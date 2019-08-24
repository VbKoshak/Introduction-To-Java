package by.epam.IntroductionToJava.task4.entity;

import by.epam.IntroductionToJava.task4.action.Show;
import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.BasicCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriage;

import static by.epam.IntroductionToJava.task4.validators.InstanceValidator.*;

public class Train {
        private Locomotive locomotive;
        private Carriage[] carriages;
        private int totalNumberOfPlaces;
        private double totalCargoLoading;       //kg
        private double totalBaggageLoading;     //kg
        private double totalBaggageSpace;       //kg
        private int carriageAmount;

        public Train(Locomotive locomotive) {
                this.locomotive = locomotive;
                carriages = new Carriage[0];
        }
        public Train(Locomotive L, Carriage C){
                this.locomotive = L;
                this.carriages = new Carriage[++carriageAmount];
                this.carriages[0] = C;
        }
        public Train(Locomotive L, Carriage[] Cs){
                this.locomotive = L;
                this.carriages = new Carriage[Cs.length];
                for (int i = 0; i < Cs.length; i++) {
                        this.carriages[i] = Cs[i];
                }
        }

        public Train(){
                locomotive = new Locomotive();
                carriages = new Carriage[0];
        }

        //inner method used to clone carriages fromm one array to another
        private void cloneCarriage(Carriage[] from, Carriage[] to){
                for (int i = 0; i < from.length; i++){
                        to[i] = from[i];
                }
        }
        //inner method used to clone carriages from one array to another starting from {startingFrom}
        private void cloneCarriage(Carriage[] from, Carriage[] to, int startingFrom){
                int length = from.length + startingFrom;
                for (int i = startingFrom,j=0; i < length; i++,j++){
                        to[i] = from[j];
                }
        }

        private void addInfo(Carriage car){
                if(hasPlacesForPassangers(car)) {
                        totalNumberOfPlaces += ((PassangerCarriage) car).getTotalNumberOfPlaces();
                } else if (hasPlaceForCargo(car)){
                        totalCargoLoading += ((BasicCarrier) car).getMaxLoading();
                } else if (hasPlacesForBaggage(car)) {
                        totalBaggageLoading += ((BaggageCarriage) car).getMaxLoading();
                        totalBaggageSpace += ((BaggageCarriage) car).getSpaceForBaggage();
                }
        }

        public void addCarriage(Carriage car){
                Carriage[] tempCarriages = new Carriage[carriageAmount +1];
                cloneCarriage(carriages,tempCarriages);
                tempCarriages[carriageAmount++] = car;
                carriages=new Carriage[carriageAmount];
                cloneCarriage(tempCarriages,carriages);
                addInfo(car);
        }
        public void addCarriage(Carriage[] cars) {
                carriageAmount += cars.length;
                Carriage[] tempCarriages = new Carriage[carriageAmount];
                cloneCarriage(carriages, tempCarriages);
                cloneCarriage(cars, tempCarriages, carriages.length);
                carriages = new Carriage[carriageAmount];
                cloneCarriage(tempCarriages, carriages);
                for (Carriage car : cars) {
                        addInfo(car);
                }
        }

        //shows info about carriages that has required number of places
        public int selectCarriagesByPlaces(int requiredNumber) {        //returns number of carriages with more places then required4
                int amount = 0;
                System.out.println("--\tSearch Results\t--");
                for(Carriage car: carriages){
                        if(hasPlacesForPassangers(car) && ((PassangerCarriage)car).getTotalNumberOfPlaces() > requiredNumber){
                                Show.showCarriage(car);
                                amount++;
                        }
                }
                return amount;
        }

        public int getTotalNumberOfPlaces(){
                return totalNumberOfPlaces;
        }

        public double getTotalCargoLoading(){
                return totalCargoLoading;
        }

        public double getTotalBaggageLoading() {
                return totalBaggageLoading;
        }

        public double getTotalBaggageSpace() {
                return totalBaggageSpace;
        }

        public Carriage[] getCarriages(){
                return carriages;
        }

        public Locomotive getLocomotive() {
                return locomotive;
        }

        public int getCarriageAmount() {return carriageAmount;}

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Train train = (Train) o;
                boolean carEquals = true;
                for (int i = 0; i < carriageAmount; i++){
                        if(!carriages[i].equals(train.getCarriages()[i])){
                                carEquals = false;
                        }
                }
                if(!carEquals) return false;
                return totalNumberOfPlaces == train.totalNumberOfPlaces &&
                        Double.compare(train.totalCargoLoading, totalCargoLoading) == 0 &&
                        Double.compare(train.totalBaggageLoading, totalBaggageLoading) == 0 &&
                        Double.compare(train.totalBaggageSpace, totalBaggageSpace) == 0 &&
                        carriageAmount == train.carriageAmount &&
                        locomotive.equals(train.getLocomotive());
        }

        @Override
        public int hashCode() {
                int carHash = 0;
                for (Carriage car: carriages){
                        carHash += car.hashCode();
                }
                return locomotive.hashCode()%carHash;
        }

        @Override
        public String toString() {
                return "Train" +
                       "\n\tTotal cargo loading: " + getTotalCargoLoading() +
                       "\n\tTotal baggage loading: " + getTotalBaggageLoading() +
                       "\n\tTotal space for baggage: " + getTotalBaggageSpace() +
                       "\n\tTotal number of places: " + getTotalNumberOfPlaces() +
                       "\n\tNumber of carriages: " + getCarriageAmount();
        }
}
