package Day218;

public class palindromeString {
    public static boolean palindrome(String str) {
        int low = 0;
        int high = str.length()-1;
        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abcdcba";
        System.out.println(palindrome(str));    
    }
}