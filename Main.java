public class Main {
    public static void main (String[] args) {
        //
        System.out.println(task1.differ(1,2,3));
        //
        task2.showFromKilos(52503);
        //
        System.out.println("Square of the ring: " + task3.ringSquare(5,7));
        //
        System.out.println(task4.isGrowing(1780));
        //
        task5.findNumberAverages(123456);
        //
        System.out.println(task6.reverse(1234897));
        //
        int[] arr = {1,2};
        task7.swap(arr);
        System.out.println(""+ arr[0] +":" + arr[1]);
        //
        int[] a = {0,0};
        int[] b = {0,5};
        int[] c = {3,0};
        System.out.println(task8.checkTriangle(a,b,c));
        //
        System.out.println(task9.dragonHeads(500));
        //

        //
        System.out.println(task11.nextDay(31,12,1985));

    }

}

