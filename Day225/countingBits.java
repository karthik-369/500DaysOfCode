
class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n+1];
        helper(answer, 1, 1);
        return answer;
    }

    private void helper(int[] answer, int bits, int i){
        if(i>=answer.length) return;
        answer[i] = bits;
        i <<= 1;
        helper(answer, bits, i);
        helper(answer, bits+1, i+1);
    }
}