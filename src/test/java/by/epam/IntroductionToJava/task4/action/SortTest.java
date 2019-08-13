package by.epam.IntroductionToJava.task4.action;

import by.epam.IntroductionToJava.task4.entity.Carriage.Carriage;
import by.epam.IntroductionToJava.task4.entity.Locomative;
import by.epam.IntroductionToJava.task4.entity.Train;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BaggageCarriageWithCells;
import by.epam.IntroductionToJava.task4.entity.baggageCarriage.BasicBaggageCarriage;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.CargoCarrier;
import by.epam.IntroductionToJava.task4.entity.cargoCarriage.LiquidCarrier;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.BasicPassangerCarriage;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriageWithRooms;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

        public int[] getId(Carriage[] cars){
                int[] arr = new int[cars.length];
                for(int i = 0; i < cars.length; i++){
                        arr[i] = cars[i].getId();
                }
                return arr;
        }

        private Locomative loc = new Locomative("Tachis 2001", 2800);
        private Train T = new Train(loc);
        private BasicBaggageCarriage car1 = new BasicBaggageCarriage((short)1973,102,200,"Lighter-800", TypeOfHook.A,250,800);
        private LiquidCarrier car2 = new LiquidCarrier((short) 2001, 203,300,"Aqua-2001b",TypeOfHook.B,"Oil",800, true, false);
        private BasicPassangerCarriage car3 = new BasicPassangerCarriage((short)2018,130,400,"Deluxo",TypeOfHook.B,20,800);
        private PassangerCarriageWithRooms car4 = new PassangerCarriageWithRooms((short)1999,280,300,"ElPabloEsco",TypeOfHook.D,1000,10,4);
        private CargoCarrier car5 = new CargoCarrier((short)2003,200,600,"Deliverance",TypeOfHook.B,"stone",2000,true,true);
        private BasicBaggageCarriage car6 = new BasicBaggageCarriage((short) 1999, 120,300,"Delyaor",TypeOfHook.C,700,1400);
        private BaggageCarriageWithCells car7 = new BaggageCarriageWithCells((short)2003,400,500,"Transit-s802",TypeOfHook.A,30,20,50);

        @Test
        public void sortById(){
                Carriage arr[] = {car7,car3,car2};
                int[] expected = {2,3,7};

                T.addCarriage(arr);
                Sort.sortById(T.getCarriages());
                int[] res = getId(T.getCarriages());

                assertArrayEquals(expected,res);
        }

        @Test
        public void sortByYear(){
                Carriage arr[] = {car1,car4,car6,car2,car7};
                int expected[] = {1,4,6,2,7};

                T.addCarriage(arr);
                Sort.sortByYear(T.getCarriages());
                int[] res = getId(T.getCarriages());

                assertArrayEquals(expected,res);
        }

        @Test
        public void sortByHook(){

                Carriage arr[] = {car3,car4,car5,car1};
                int expected[] = {1,3,5,4};

                T.addCarriage(arr);
                Sort.sortByHook(T.getCarriages());
                int[] res = getId(T.getCarriages());

                assertArrayEquals(expected,res);

        }
}
