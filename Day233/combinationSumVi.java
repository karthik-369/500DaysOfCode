class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0 ){
            return 0;
        }
        int dp[] = new int[target+1];
        dp[0] = 1;
        int len = nums.length;
        for (int i=1; i<=target; i++) {
            for (int j=0; j<len; j++) {
                if (nums[j] <= i) {
                    dp[i] = dp[i] + dp[i- nums[j]];
                }
            }
        }
        return dp[target];
    }
}
