package Day204;

class Solution{
    public long coinChange(int n ,int[] coins, int target){
        long ans[] = new long[target+1];
        ans[0]= 1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=target;j++){
                ans[j] += ans[j - coins[i]];
            }
        }
        return ans[target];
    }
}

public class testCoin{
    public static void main(String[] args){
        int n  = 3;
        int coins[] = {1,2,3};
        int target = 4;
        Solution sol = new Solution();
        System.out.println(sol.coinChange(n, coins, target));
    }
}
