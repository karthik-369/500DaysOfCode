package Day251;


public class decodedStringAtIndex {

    public static String decodeAtIndex(String s, int k) {
        
        long n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n *= (c-'0');
            } else {
                n++;
            }
        }
        
        for (int i=s.length()-1; i>=0; i--) {
            char temp = s.charAt(i);
            if (Character.isDigit(temp)) {
                n /= (temp-'0');
                k %= n;
            }else{
                if (k == 0  || n == k) {
                    // String t = new String();
                    // t += temp;
                    return String.valueOf(temp);
                }
                n--;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String s1 = "leet2code3";
        int k1 = 10;
        String s2 = "ha22";
        int k2 = 5;
        String s3 = "a2345678999999999999999";
        int k3 = 1;
        System.out.println(decodeAtIndex(s1, k1));
        System.out.println(decodeAtIndex(s2, k2));
        System.out.println(decodeAtIndex(s3, k3));
    }
}