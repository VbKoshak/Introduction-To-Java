package by.epam.IntroductionToJava;

import by.epam.IntroductionToJava.task4.entity.Locomative;
import by.epam.IntroductionToJava.task4.entity.Train;
import by.epam.IntroductionToJava.task4.entity.additionalInfo.TypeOfHook;
import by.epam.IntroductionToJava.task4.entity.passangerCarriage.PassangerCarriage;

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

        Locomative l1 = new Locomative("DESTROYER",1400);
        Locomative l2 = new Locomative("DESTROYER",1400);
        Train t1 = new Train(l1);
        Train t2 = new Train(l2);
        PassangerCarriage pc1 = new PassangerCarriage((short) 1954,126,103.6,"EUKALIPTO_AR", TypeOfHook.A,105,20);
        PassangerCarriage pc2 =  new PassangerCarriage((short) 1954,126,103.6,"EUKALIPTO_AR", TypeOfHook.A,105,20);
        t1.addCarriage(pc1);
        t2.addCarriage(pc2);
        System.out.println(t1.equals(t2));
        System.out.println("" + pc1.hashCode() +"\n" + pc2.hashCode() + "\n" + t1.getLocomative().hashCode() + "\n" + t2.getLocomative().hashCode());
    }

}

