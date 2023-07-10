//LeetCode 29
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor ==-1){
            return Integer.MAX_VALUE;
        }
        int answer = 0;
        boolean flag = (dividend< 0)!=(divisor<0);
        long div = Math.abs((long)dividend);
        long dis = Math.abs((long)divisor);
        while(div>=dis){
            int count = 0;
            while(div>=(dis<<count)){
                count++;
            }
            count--;
            div-=dis<<count;
            answer += 1<<count;
        }
        return flag? -answer: answer;
    }
}