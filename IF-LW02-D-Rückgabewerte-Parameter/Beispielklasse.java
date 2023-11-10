public class Beispielklasse {

    public static void main(String[] args) {
        System.out.println("Aufgabe 1:");
        aufgabe1();
        System.out.println("\nAufgabe 2:");
        aufgabe2();
    }

    // Methoden
    public static double flaecheRechteck(double a, double b) {
        double flaeche;
        flaeche = a * b;
        return flaeche;
    }

    public static void aufgabe1() {
        double area1 = flaecheRechteck(2, 3);
        System.out.println("Fläche des Rechtecks mit Seitenlängen 2 und 3: " + area1);
        double area2 = flaecheRechteck(2.3, 3.4);
        System.out.println("Fläche des Rechtecks mit Seitenlängen 2.3 und 3.4: " + area2);
        double area3 = flaecheRechteck(3, 3);
        System.out.println("Fläche des Quadrats mit Seitenlänge 3: " + area3);
    }

    public static double flaecheRechtwinkligesDreieck(double a, double b) {
        return a * b * 0.5f;
    }

    public static double flaecheKreis(double r) {
        double f;
        f = r * r * Math.PI;
        return f;
    }

    public static double volumenQuader(double a, double b, double c) {
        return a * b * c;

    }

    public static void aufgabe2() {
        double area1 = flaecheRechtwinkligesDreieck(2, 3);
        System.out.println("Fläche des rechtwinkligen Dreiecks mit Katheten 2 und 3: " + area1);
        double area2 = flaecheKreis(4);
        System.out.println("Flächeninhalt eines Kreises mit Radius 4: " + area2);
        double volume1 = volumenQuader(4, 5, 6);
        System.out.println("Volumen eines Quaders mit Seitenlängen 4, 5 und 6: " + volume1);
    }

}
