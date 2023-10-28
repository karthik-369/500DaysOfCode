class Solution {
    public int countVowelPermutation(int n) {
        int mod = 1000000007;
        long arr[] = {1,1,1,1,1};
        for (int i=0; i<n-1; i++) {
            long temp[] = {0,0,0,0,0};
            temp[0] = (arr[1]+arr[2]+arr[4])%mod;
            temp[1] = (arr[0] +arr[2]) %mod;
            temp[2] = (arr[1]+arr[3]) %mod;
            temp[3] = (arr[2])%mod;
            temp[4] = (arr[2]+arr[3])%mod;
            arr = temp;
        }
        long answer = 0;
        for (long v: arr) {
            answer = (answer+v)%mod;
        }
        return (int)answer;
    }
}