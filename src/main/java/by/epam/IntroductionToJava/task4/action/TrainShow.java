package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Train;

public class TrainShow {

        public static void show(Train T){
                System.out.println("--\tTrain\t--" +
                        "\n\tTotal cargo loadout: " + T.getTotalCargoLoadout() +
                        "\n\tTotal baggage loadout: " + T.getTotalBaggageLoadout() +
                        "\n\tTotal space for baggage: " + T.getTotalBaggageSpace() +
                        "\n\tTotal number of places: " + T.getTotalNumberOfPlaces());
                T.showLocomative();
                T.showCarriages();
                System.out.println("--\t--\t--");
        }
}
