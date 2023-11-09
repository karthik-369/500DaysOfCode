class Solution {
    public int countHomogenous(String s) {
        long answer = 0;
        long count = 1;
        int mod = 1000000007;
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                answer =(answer   +  ((count*(count+1)%mod) % mod) / 2)%mod ;
                count = 1;
            } else {
                count++;
                count %= mod;
            }
        }
        answer = (answer   +  ((count*(count+1)%mod) % mod) / 2)%mod;
        return (int)answer%mod;
    }
}