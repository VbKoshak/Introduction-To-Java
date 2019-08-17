package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.Locomative;
import by.epam.IntroductionToJava.task4.entity.Train;

import static by.epam.IntroductionToJava.task4.validators.InstanceValidator.*;

public class Show {

        private final static String LINE = "--\t--\t--";



        public static void showCarriages(Carriage[] arr){
                System.out.println("Carriages");
                for (Carriage car: arr){
                        System.out.println(car.toString());
                }

        }

        public static void showCarriages(Train T){
                showCarriages(T.getCarriages());
        }

        public static void showLocomative(Locomative L){
                System.out.println(L.toString());
        }

        public static void showLocomative(Train T){
                System.out.println(T.getLocomative().toString());
        }

        public static void showTrain(Train T){
                System.out.println(LINE);
                T.toString();
                showLocomative(T);
                if (T.getCarriageamount() > 0) {
                        showCarriages(T);
                }
                System.out.println(LINE);
        }

        public static void showCarriage(Carriage car){
                System.out.println(car.toString());
        }

        public static void showInfoAboutCarriages(Train T){

                int baggageCarriageAmount = 0;
                int cargoCarriageAmount = 0;
                int passangerCarriageAmout = 0;
                int others = 0;

                for (Carriage car: T.getCarriages()){
                        if (hasPlaceForCargo(car)){
                                cargoCarriageAmount++;
                        } else if (hasPlacesForPassangers(car)){
                                passangerCarriageAmout++;
                        } else if (hasPlacesForBaggage(car)){
                                baggageCarriageAmount++;
                        } else {
                                others++;
                        }
                }


                System.out.println(
                        "Total amount of carriages: " + T.getCarriageamount() +
                        "\n\tCargo carriers: " + cargoCarriageAmount +
                        "\n\tPassanger transporters: " + passangerCarriageAmout +
                        "\n\tBaggage carriers: " + baggageCarriageAmount +
                        "\n\tOther carriaages: " + others
                        );
        }
}
