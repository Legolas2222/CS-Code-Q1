import java.util.Locale;

public class Palindrom {

    public static boolean checkPalindrom(String input) {
        if (input.length() <= 1) {
            return true;
        } else {
            if (input.charAt(0) == input.charAt(input.length() - 1)
                    & checkPalindrom(input.substring(1, input.length() - 1))) {
                return true;
            } else {
                return false;
            }

        }
    }
    public static boolean checkPalindromIgnoreCase(String input) {
        String newString = input.toUpperCase(Locale.ROOT);
        return checkPalindrom(newString);
    }
    public static void main(String[] args) {
        // Should be false
        System.out.println(Palindrom.checkPalindrom("bruno"));
        // Should be true
        System.out.println(Palindrom.checkPalindrom("OttO"));
        // Should be false
        System.out.println(Palindrom.checkPalindrom("Otto"));
        // Should be true
        System.out.println(Palindrom.checkPalindromIgnoreCase("Otto"));

    }
}