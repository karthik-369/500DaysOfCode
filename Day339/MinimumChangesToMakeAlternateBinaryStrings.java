class Solution {
    public int minOperations(String s) {
        int a = 0, b = 0;
        for (int i=0; i<s.length(); i++) {
            if (i%2 == 0) {
                if (s.charAt(i) == '0') {
                    a++;
                }
                if (s.charAt(i) == '1') {
                    b++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    a++;
                }
                if (s.charAt(i)== '0') {
                    b++;
                }
            }
        }
        return Math.min(a, b);
    }
}