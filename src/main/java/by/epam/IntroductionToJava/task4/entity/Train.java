package by.epam.IntroductionToJava.task4.entity;

import by.epam.IntroductionToJava.task4.action.CarriageShow;
import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BasicBaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.BasicCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.BasicPassangerCarriage;

import java.util.ArrayList;

import static by.epam.IntroductionToJava.task4.validators.InstanceValidator.*;

public class Train {
        private Locomative locomative;
        private ArrayList<Carriage> carriages = new ArrayList<Carriage>();
        private int totalNumberOfPlaces;
        private double totalCargoLoadout;
        private double totalBaggageLoadout;
        private double totalBaggageSpace;

        {
                totalNumberOfPlaces = 0;
                totalCargoLoadout = 0.0;
                totalBaggageLoadout = 0.0;
                totalBaggageSpace = 0.0;
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

        public void addCarriage(Carriage car){
                carriages.add(car);
                addInfo(car);
        }

        public void addCarriage(Carriage[] cars){
                for (Carriage car: cars){
                        carriages.add(car);
                        addInfo(car);
                }
        }

        public void selectCarriagesByPlaces(int requiredNumber) {
                System.out.println("--\tSearch Results\t--");
                for(Carriage car: carriages){
                        if(hasPlacesForPassangers(car) && ((BasicPassangerCarriage)car).getTotalNumberOfPlaces() > requiredNumber){
                                CarriageShow.show(car);
                        }
                }
        }

        public int getTotalNumberOfPlaces(){
                return totalNumberOfPlaces;
        }



        public void show(){
                System.out.println("--\tTrain\t--");
                System.out.println("\nTotal cargo loadout: " + totalCargoLoadout +
                        "\nTotal baggage loadout: " + totalBaggageLoadout +
                        "\nTotal space for baggage: " + totalBaggageSpace +
                        "\nTotal number of places: " + totalNumberOfPlaces);
                System.out.println(locomative.toString());
                CarriageShow.show(carriages);

        }
}
