public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int answer =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                answer++;
            }
        }
        return answer;
    }
}