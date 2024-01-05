package Day341;

// import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    public static  int solve(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        dp[0][0] = 1;
        for (int i=1; i<=n; i++) {
           for (int j=1;j<=target;j++) {
               int answer = 0;
               for (int t=1; t<=k; t++) {
                   if (j - t >= 0) {
                    answer = (answer + dp[i-1][j-t])%1000000007;
                   }
               }
               dp[i][j] = answer;
           }
        }
        return dp[n][target];
    }
    public static  int numRollsToTarget(int n, int k, int target) {
       
        return solve(n, k, target);
    }
    public static void main(String[] args) {
        int n1 =1, k1 =6, target1 = 3;
        int n2 = 2, k2 = 6, target2 = 7;
        int n3 = 30, k3=30, target3=500;
        System.out.println(numRollsToTarget(n1, k1, target1));
        System.out.println(numRollsToTarget(n2, k2, target2));
        System.out.println(numRollsToTarget(n3, k3, target3));
    }
}