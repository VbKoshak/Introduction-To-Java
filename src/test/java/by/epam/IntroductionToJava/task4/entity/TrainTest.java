package by.epam.IntroductionToJava.task4.entity;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriageWithCells;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.CargoCarrier;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.LiquidCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriage;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriageWithRooms;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrainTest {

        private Locomotive loc = new Locomotive("Tachis 2001", 2800);
        private Train T = new Train(loc);
        private BaggageCarriage car1 = new BaggageCarriage((short)1973,102,200,"Lighter-800", TypeOfHook.A,250,800);
        private LiquidCarrier car2 = new LiquidCarrier((short) 2001, 203,300,"Aqua-2001b",TypeOfHook.B,"Oil",800, true, false);
        private PassangerCarriage car3 = new PassangerCarriage((short)2018,130,400,"Deluxo",TypeOfHook.B,20,800);
        private PassangerCarriageWithRooms car4 = new PassangerCarriageWithRooms((short)1999,280,300,"ElPabloEsco",TypeOfHook.D,1000,10,4);
        private CargoCarrier car5 = new CargoCarrier((short)2003,200,600,"Deliverance",TypeOfHook.B,"stone",2000,true,true);
        private BaggageCarriage car6 = new BaggageCarriage((short) 1999, 120,300,"Delyaor",TypeOfHook.C,700,1400);
        private BaggageCarriageWithCells car7 = new BaggageCarriageWithCells((short)2003,400,500,"Transit-s802",TypeOfHook.A,30,20,50);

        @Test
        public void addCarriage() {
                T.addCarriage(car1);
                T.addCarriage(car2);
                assertEquals(2,T.getCarriages().length);
        }

        @Test
        public void addCarriage1() {
                Carriage[] arr = {car1,car2};
                T.addCarriage(arr);
                assertEquals(2,T.getCarriages().length);
        }

        @Test
        public void selectCarriagesByPlaces() {
                T.addCarriage(car3);
                T.addCarriage(car4);
                assertEquals(1,T.selectCarriagesByPlaces(30));
        }

        @Test
        public void getTotalNumberOfPlaces() {
                T.addCarriage(car3);
                T.addCarriage(car4);
                assertEquals(60,T.getTotalNumberOfPlaces());
        }

        @Test
        public void getTotalCargoLoadout() {
                T.addCarriage(car2);
                T.addCarriage(car5);
                assertEquals(2800,T.getTotalCargoLoading(),0.01);
        }

        @Test
        public void getTotalBaggageLoadout() {
                T.addCarriage(car6);
                T.addCarriage(car7);
                assertEquals(2900,T.getTotalBaggageLoading(),0.01);
        }

        @Test
        public void getTotalBaggageSpace() {
                T.addCarriage(car6);
                T.addCarriage(car7);
                assertEquals(1300,T.getTotalBaggageSpace(),0.01);
        }
}