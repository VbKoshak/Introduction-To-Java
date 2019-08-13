package by.epam.IntroductionToJava.task4.entity;

import by.epam.IntroductionToJava.task4.action.Show;
import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BasicBaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.BasicCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.BasicPassangerCarriage;

import java.util.Arrays;
import java.util.Objects;

import static by.epam.IntroductionToJava.task4.validators.InstanceValidator.*;

public class Train {
        private Locomative locomative;
        private Carriage[] carriages;
        private int totalNumberOfPlaces;
        private double totalCargoLoadout;
        private double totalBaggageLoadout;
        private double totalBaggageSpace;
        private int carriageamount;

        {
                carriageamount = 0;
                carriages = new Carriage[0];
                totalNumberOfPlaces = 0;
                totalCargoLoadout = 0.0;
                totalBaggageLoadout = 0.0;
                totalBaggageSpace = 0.0;
        }

        private void cloneCarriage(Carriage[] from, Carriage[] to){
                for (int i = 0; i < from.length; i++){
                        to[i] = from[i];
                }
        }
        private void cloneCarriage(Carriage[] from, Carriage[] to, int startingFrom){
                int length = from.length + startingFrom;
                for (int i = startingFrom,j=0; i < length; i++,j++){
                        to[i] = from[j];
                }
        }

        private void addInfo(Carriage car){
                if(hasPlacesForPassangers(car)) {
                        totalNumberOfPlaces += ((BasicPassangerCarriage) car).getTotalNumberOfPlaces();
                } else if (hasPlaceForCargo(car)){
                        totalCargoLoadout += ((BasicCarrier) car).getMaxLoadout();
                } else if (hasPlacesForBaggage(car)) {
                        totalBaggageLoadout += ((BasicBaggageCarriage) car).getMaxLoadout();
                        totalBaggageSpace += ((BasicBaggageCarriage) car).getSpaceForBaggage();
                }
        }

        public Train(Locomative locomative) {
                this.locomative = locomative;
        }

        public Train(Locomative L, Carriage C){
                this.locomative = L;
                this.carriages = new Carriage[++carriageamount];
                this.carriages[0] = C;
        }

        public Train(Locomative L, Carriage[] Cs){
                this.locomative = L;
                this.carriages = new Carriage[Cs.length];
                for (int i = 0; i < Cs.length; i++) {
                        this.carriages[i] = Cs[i];
                }
        }

        public void addCarriage(Carriage car){
                Carriage[] tempCarriages = new Carriage[carriageamount+1];
                cloneCarriage(carriages,tempCarriages);
                tempCarriages[carriageamount++] = car;
                carriages=new Carriage[carriageamount];
                cloneCarriage(tempCarriages,carriages);
                addInfo(car);
        }

        public void addCarriage(Carriage[] cars) {
                carriageamount += cars.length;
                Carriage[] tempCarriages = new Carriage[carriageamount];
                cloneCarriage(carriages, tempCarriages);
                cloneCarriage(cars, tempCarriages, carriages.length);
                carriages = new Carriage[carriageamount];
                cloneCarriage(tempCarriages, carriages);
                for (Carriage car : cars) {
                        addInfo(car);
                }
        }

        public int selectCarriagesByPlaces(int requiredNumber) {        //returns number of carriages with more places then required4
                int amount = 0;
                System.out.println("--\tSearch Results\t--");
                for(Carriage car: carriages){
                        if(hasPlacesForPassangers(car) && ((BasicPassangerCarriage)car).getTotalNumberOfPlaces() > requiredNumber){
                                Show.showCarriage(car);
                                amount++;
                        }
                }
                return amount;
        }

        public int getTotalNumberOfPlaces(){
                return totalNumberOfPlaces;
        }

        public double getTotalCargoLoadout(){
                return totalCargoLoadout;
        }

        public double getTotalBaggageLoadout() {
                return totalBaggageLoadout;
        }

        public double getTotalBaggageSpace() {
                return totalBaggageSpace;
        }

        public Carriage[] getCarriages(){
                return carriages;
        }

        public Locomative getLocomative() {
                return locomative;
        }

        public int getCarriageamount() {return carriageamount;}

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Train train = (Train) o;
                return totalNumberOfPlaces == train.totalNumberOfPlaces &&
                        Double.compare(train.totalCargoLoadout, totalCargoLoadout) == 0 &&
                        Double.compare(train.totalBaggageLoadout, totalBaggageLoadout) == 0 &&
                        Double.compare(train.totalBaggageSpace, totalBaggageSpace) == 0 &&
                        carriageamount == train.carriageamount &&
                        Objects.equals(locomative, train.locomative) &&
                        Arrays.equals(carriages, train.carriages);
        }

        @Override
        public int hashCode() {
                int carHash = 0;
                for (Carriage car: carriages){
                        carHash += car.hashCode();
                }
                return locomative.hashCode()%carHash;
        }

        @Override
        public String toString() {
                return "Train" +
                       "\n\tTotal cargo loadout: " + getTotalCargoLoadout() +
                       "\n\tTotal baggage loadout: " + getTotalBaggageLoadout() +
                       "\n\tTotal space for baggage: " + getTotalBaggageSpace() +
                       "\n\tTotal number of places: " + getTotalNumberOfPlaces() +
                       "\n\tNumber of carriages: " + getCarriageamount();
        }
}
