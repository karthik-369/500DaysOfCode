class Solution {
    public int numberOfBeams(String[] bank) {
        int temp = 0, answer = 0;
        for (char c: bank[0].toCharArray()) {
            temp += c-'0';
        }
        for (int i=1; i<bank.length; i++) {
            int pre = 0;
            for (char c : bank[i].toCharArray()) {
                pre += c-'0';
            }
            if (pre != 0) {
                answer += temp * pre;
                temp = pre;
            }
        }
        return answer;
    }
}