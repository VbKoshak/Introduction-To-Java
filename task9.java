public class task9 {
        public static int dragonHeads(int age){
                int heads = 3;          //initial value

                if (age < 200) {
                        heads += 3* age;
                } else {
                        heads += 3 * 199;
                        if (age < 300) {
                                heads += 2 * ( age - 199);
                        } else {
                                heads += 2 * 100;
                                if (age >= 300) {
                                        heads += (age - 299);
                                }
                        }
                }

                return heads;
        }
}
