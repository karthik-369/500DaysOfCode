//leetcode hard 1751 DP
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b)->{if(a[0]==b[0])return a[1]-b[1];return a[0]-b[0];});
        // for(int temp[]: events){
        //     System.out.println(Arrays.toString(temp));
        // }
        int arr[][] = new int[events.length+1][k+1];
        for(int temp[]:arr){
            Arrays.fill(temp,-1);
        }
        int answer = rec(0, events, -1, k, arr);
        return answer;
    }
    public int rec(int i, int[][] events, int pre, int k, int arr[][]){
        if(i==events.length){
            return 0;
        }
        if(k==0){
            return 0;
        }
        if(arr[pre+1][k]!=-1){
            return arr[pre+1][k];
        }
        int yes =0;
        int no = 0;
        if(pre == -1||events[pre][1]<events[i][0]){
            yes = events[i][2]+rec(i+1, events, i, k-1, arr);
        }
        no = rec(i+1, events, pre, k, arr);
        arr[pre+1][k] = Math.max(yes, no);
        return arr[pre+1][k];
    }
}