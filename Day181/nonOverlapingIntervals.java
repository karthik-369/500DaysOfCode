class Pair{
    int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Pair> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        // for(int temp[]:intervals){
        //     System.out.println(Arrays.toString(temp));
        // }
        int end = intervals[0][1];
        int count = 0;
        int len = intervals.length;
        for(int i=1;i<len;i++){
            if(intervals[i][0]<end){
                count++;
                end = Math.min(intervals[i][1], end);
            }else{
                
                end = intervals[i][1];
            }
        }
        return count;
    }
}