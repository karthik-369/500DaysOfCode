package Day249;

public class findTheDifference {
    public static char diff(String s, String t) {
        int temp = 0;
        for (int i=0; i<s.length(); i++) {
            temp+=(int)s.charAt(i);
        }
        for (int i=0; i<t.length(); i++) {
            temp -= (int)t.charAt(i);
        }
        return (char)Math.abs(temp);
    }
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(diff(s, t));
    }
}