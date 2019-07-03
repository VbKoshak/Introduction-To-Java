public class task2 {
        public static void showFromKilos (double kg) {
                double mg = kg * 1e6;
                double gr = kg * 1e3;
                double t = kg * 1e-3;
                System.out.println("Milligrams: " + String.format("%f", mg));
                System.out.println("Grams: " + String.format("%f", gr));
                System.out.println("Tons: " + String.format("%f", t));
        }
}
