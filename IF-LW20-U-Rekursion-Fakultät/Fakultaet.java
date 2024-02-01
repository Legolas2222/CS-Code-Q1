public class Fakultaet {

    public static int fak(int n) {
        if(n == 1) { // Rekursionabbruchbedingung oder auch Rekursionsanker
            return 1;
        }
        else {
            return n * fak(n-1);
        }
    } 

    public static void main(String[] args) {
        System.out.println(fak(4));
        System.out.println(fak(5));
        System.out.println(fak(1));
    }
}