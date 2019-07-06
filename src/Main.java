public class Main {
    public static void main (String[] args) {
        //
        System.out.println(task1.MainTask1.differ(1,2,3));
        //
        task1.MainTask1.showFromKilos(52503);
        //
        System.out.println("Square of the ring: " + task1.MainTask1.ringSquare(5,7));
        //
        System.out.println(task1.MainTask1.isGrowing(1780));
        //
        task1.MainTask1.findNumberAverages(123456);
        //
        System.out.println(task1.MainTask1.reverse(1234897));
        //
        int[] arr = {1,2};
        task1.MainTask1.swap(arr);
        System.out.println(""+ arr[0] +":" + arr[1]);
        //
        int[] a = {0,0};
        int[] b = {0,5};
        int[] c = {3,0};
        System.out.println(task1.MainTask2.checkTriangle(a,b,c));
        //
        System.out.println(task1.MainTask2.dragonHeads(500));
        //
        task1.MainTask2.characterCheck('A');
        task1.MainTask2.characterCheck2('o');
        //
        System.out.println(task1.MainTask2.nextDay(31,12,1985));

    }

}

