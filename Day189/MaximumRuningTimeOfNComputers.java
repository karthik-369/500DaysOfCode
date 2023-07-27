class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long power = 0;
        long low = 1;
        for(int i: batteries){
            power+=i;
        }
        long high = power/n;
        while(low<high){
            long mid = high - (high-low)/2;
            long store = 0;
            for(int i: batteries){
                store += Math.min(i, mid);
            }
            if(store>=(long)(n*mid)){
                low = mid;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}