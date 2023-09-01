class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        helper(ans, 1, 1);
        return ans;
    }

    private void helper(int[] ans, int bits, int i){
        if(i>=ans.length) return;
        ans[i] = bits;
        i <<= 1;
        helper(ans, bits, i);
        helper(ans, bits+1, i+1);
    }
}