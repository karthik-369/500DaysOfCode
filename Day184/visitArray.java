class Solution {
    public long maxScore(int[] nums, int x) {
        long arr[] = new long[]{0,0};
        long answer = 0;
        for(int i=nums.length-1;i>=0;i--){
            int parity = nums[i]%2;
            answer = Math.max(0, Math.max(arr[parity], arr[1-parity]-x)+nums[i]);
            arr[parity] = Math.max(arr[parity], answer);
        }
        return answer;
    }
}