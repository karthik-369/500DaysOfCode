public class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        int[] arr = new int[l + 1];

        if (l == 0 || s.charAt(0) == '0') {
            return 0;
        }

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= l; i++) {
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
                arr[i] = arr[i - 1];
            }
            if (s.charAt(i - 2) == '1') {
                arr[i] += arr[i - 2];
            } else if (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6') {
                arr[i] += arr[i - 2];
            }
        }

        return arr[l];
    }
}
