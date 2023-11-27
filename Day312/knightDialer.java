
class Solution {
    public int knightDialer(int n) {
        n--;
        long pos[] = new long[10];
        for (int i=0; i<10; i++){
            pos[i] = 1;
        }
        while (n > 0) {
            long temp[] = new long[10];
            temp[0] = (pos[4] + pos[6]) % 1000000007;
            temp[1] = (pos[6] + pos[8]) % 1000000007;
            temp[2] = (pos[7] + pos[9]) % 1000000007;
            temp[3] = (pos[4] + pos[8]) % 1000000007;
            temp[4] = (pos[3] + pos[9] + pos[0]) % 1000000007;
            temp[6] = (pos[1] + pos[7] + pos[0]) % 1000000007;
            temp[7] = (pos[2] + pos[6]) % 1000000007;
            temp[8] = (pos[1] + pos[3]) % 1000000007;
            temp[9] = (pos[2] + pos[4]) % 1000000007;  
            pos = temp;
            n--;     
        }
        long answer = 0;
        for (int i=0 ;i<10; i++) {
            answer  = (answer + pos[i]) % 1000000007;
        }
        return (int)answer;
    }
}