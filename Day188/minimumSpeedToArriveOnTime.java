class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 1000000007;
        
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(cal(dist, mid)<=hour){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low>10000000?-1:low;
    }
    public double cal(int dist[], int speed){
        double t = 0;
        for(int i=0;i<dist.length-1;i++){

                t+=Math.ceil( (double)dist[i]/ (double)speed);
        }
        t+=(double)dist[dist.length-1]/(double)speed;
        return t;
    }
}