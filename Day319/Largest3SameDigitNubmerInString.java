class Solution {
    public String largestGoodInteger(String num) {
        if (num.length() <=2) {
            return "";
        }
        int max = -1;
        for (int i=2; i<num.length(); i++) {
            if (num.charAt(i-2) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i)) {
                if ((num.charAt(i)-'0')>max) {
                    max = num.charAt(i)-'0';
                }
            }
        }
        return max == -1? "": (""+max+""+max+""+max);
    }
}