package Day238;

public class perfectSumProblem {
    public static int mod = 1000000007;
    
    public static int perfectSum(int n, int arr[], int sum) {
    
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for (int i=0;i<n; i++) {
            for (int j=sum; j>= arr[i]; j--) {
                dp[j] = (dp[j] + dp[j-arr[i]])%1000000007;
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        int arr[] = {9 ,7 ,0 ,3 ,9 ,8 ,6 ,5 ,7 ,6};
        int n = 10;
        System.out.println(perfectSum(n, arr,31));
    }
}