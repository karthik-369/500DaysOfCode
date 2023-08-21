package Day214;
class repeatedSubstringPattern {
    public static boolean rsp(String s) {
        int n = s.length();
        for (int i=n/2; i>0; i--) {
            if (n % i == 0) {
                String temp = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                int len = n / i;
                for (int j=0; j<len; j++) {
                    sb.append(temp);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
  
    }
    public static boolean orsp(String str) {
        int len = str.length();
        for (int i=len/2; i>0; i--) {
            if (len%2==0 && str.charAt(i-1) == str.charAt(len-1)) {
                String temp = str.substring(0, i);
                int l = len / i;
                if (temp.repeat(l).equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "abcabcabcabc";
        System.out.println(rsp(str));
    }
}