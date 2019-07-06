import static java.lang.Double.NaN;

public class task3 {
        public static double ringSquare(int R1, int R2){
                if (R2 >= R1){
                        return NaN;
                }
                return (Math.PI*Math.pow(R1,2)) - (Math.PI*Math.pow(R2,2));
        }
}
