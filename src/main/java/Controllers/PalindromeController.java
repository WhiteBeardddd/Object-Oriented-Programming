package Controllers;

public class PalindromeController {
    public static boolean isPalindrome(String s){
        s = s.toLowerCase();
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--){
            reverse = reverse + s.charAt(i);
        }
        return (s.equals(reverse));
    }
}
