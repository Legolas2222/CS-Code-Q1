import java.util.Scanner;

public class TestSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib die Nummer des nächsten Films ein");
        int zahl = scanner.nextInt();
        switch (zahl) {
            case 1: {
                System.out.println("Fantastic Beasts and Where to find them");
                break;
            }
            case 2: {
                System.out.println("Tenet");
                break;
            }
            case 3: {
                System.out.println("Knives Out");
                break;
            }
            default: {
                System.out.println("Ungültige Position des Lieblingsfilms!");
            }
        }
        scanner.close();
    }
}
