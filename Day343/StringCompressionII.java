class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int arr[][] = new int[110][110];
        for (int i=0; i<=n; i++) {
            for (int j=0;j <=n; j++) {

            arr[i][j] = 9999;
            }
        }
        arr[0][0] = 0;
        for (int i=1; i<=n; i++) {
            for (int j=0;j <=k; j++) {
                int count =0, temp = 0;
                for (int t=i; t>=1; t--) {
                    if (s.charAt(t-1) == s.charAt(i-1)) {
                        count++;
                    } else {
                        temp++;
                    }
                    if (j - temp >= 0) {
                        arr[i][j] = Math.min(arr[i][j], arr[t-1][j-temp]+1+(count>=100?3 : count>=10?2:count>=2?1:0));
                    }
                }
                if (j > 0) {
                    arr[i][j] = Math.min(arr[i][j], arr[i-1][j-1]);
                }
            }
        }
        return arr[n][k];
    }
}