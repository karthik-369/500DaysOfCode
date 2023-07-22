class Solution {
public:
    int numberOfWays(int n, int x) {
        vector<int>dp(n+1, 0);
        dp[0] = 1;
        int mod = 1e9+7;
        for(int i=1;i<=n;i++){
            long long int y = pow(i,x);
            for(int j=n;j>=i;j--){
                if(j>=y){
                    dp[j] = (dp[j]%mod+dp[j-y]%mod);
                }
            }
        }
        return dp[n]%mod;
    }
    
};