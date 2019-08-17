package by.epam.IntroductionToJava;

import by.epam.IntroductionToJava.task4.action.Show;
import by.epam.IntroductionToJava.task4.entity.Train;

import static by.epam.IntroductionToJava.task4.reader.Factory.buildTrainFromFile;

public class main {
    public static void main (String[] args) {
//        //
//        System.out.println(MainTask1.differ(1,2,3));
//        //
//        MainTask1.showFromKilos(52503);
//        //
//        System.out.println("Square of the ring: " + MainTask1.ringSquare(5,7));
//        //
//        System.out.println(MainTask1.isGrowing(1780));
//        //
//        MainTask1.findNumberAverages(123456);
//        //
//        System.out.println(MainTask1.reverse(1234897));
//        //
//        int[] arr = {1,2};
//        MainTask1.swap(arr);
//        System.out.println(""+ arr[0] +":" + arr[1]);
//        //
//        int[] a = {0,0};
//        int[] b = {0,5};
//        int[] c = {3,0};
//        System.out.println(MainTask2.checkTriangle(a,b,c));
//        //
//        System.out.println(MainTask2.dragonHeads(500));
//        //
//        MainTask2.characterCheck('A');
//        MainTask2.characterCheck2('o');
//        //
//        System.out.println(MainTask2.nextDay(31,12,1985));
//        //
//        System.out.println(by.epam.IntroductionToJava.task2.MainTask.headsOrTails(300));
//        //

        Train T = buildTrainFromFile("wrongcarriageinput.txt");
        Show.showTrain(T);

    }

}

