class Solution {
    public int maxScore(String s) {
        int answer =0, zero = 0, one = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                one++;
            }
        }
        for (int i=0; i<s.length()-1;i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one--;
            }
            answer = Math.max(answer, one + zero);
        }
        return answer;
    }
}