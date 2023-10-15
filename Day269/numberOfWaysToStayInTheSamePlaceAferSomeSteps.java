package Day269;

public class numberOfWaysToStayInTheSamePlaceAferSomeSteps {

    public static int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        int max = Math.min(arrLen-1, steps/2);
        int dp[][] = new int[steps+1][max+1];
        dp[0][0] = 1;
        for (int i=1;i<=steps; i++) {
            for (int j=0; j<=max; j++) {
                dp[i][j] = dp[i-1][j];
                if (j>0){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1])%mod;
                }
                if (j<max) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) %mod;
                }
            }
        }
        return dp[steps][0];
    }
    public static void main(String[] args) {
        int steps1 = 3, arrLen1 = 2;
        int steps2 = 2, arrLen2 = 4;
        int steps3 = 4, arrLen3 = 2;
        System.out.println(numWays(steps1, arrLen1));
        System.out.println(numWays(steps2, arrLen2));
        System.out.println(numWays(steps3, arrLen3));
    }
}