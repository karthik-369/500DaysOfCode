package Day219;

import java.util.Arrays;

public class maximumLengthOfPairChains {

    public static int maxChain(int pairs[][]) {
        int len = pairs.length;
        if (len == 1) {
            return 1;
        }
        int dp[] = new int[len];
         int max = 1;
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (a, b)-> a[0]-b[0]);
        for (int i=1; i<len; i++) {
            for(int j=0;j <i; j++) {
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
             max = Math.max(max, dp[i]);
        }
       
        return max;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2},{7,8},{4,5}};
        System.out.println(maxChain(arr));
    }
}