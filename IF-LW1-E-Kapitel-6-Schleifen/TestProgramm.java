public class TestProgramm {
    public static void Aufgabe2() {
        int x = 0;
        for (int i = 0; i < 100; ++i) {
            x += i;
            System.out.println(x);
            if (x > 100) {
                break;
            }
        }
    }

    public static void Aufgabe3() {
        for (int i = 0; i < 100; ++i) {
            
            System.out.println(i + " ist...");
            // Durch 3 Teilbar
            if(i % 3 == 0) {
                System.out.println("...durch 3 teilbar");
            }
            if(i % 5 != 0 && i % 4 == 0) {
                System.out.println("...durch 4, aber nicht durch 5 teilbar");
            }

            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) {
                System.out.println("...eine Primzahl \n");
            }
            else {
                System.out.println("...ist keine Primzahl \n");
            }
            isPrime = true;
        }
    }

    public static void main(String[] args) {
        // Aufgabe2();
        // Aufgabe3();
    }
}
