class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int arr[] = new int[len];
        for(int i=len-1;i>=0;i--){
            arr[i] = nums[i];
            for(int j=i+1;j<len;j++){
                arr[j] = Math.max(nums[i]-arr[j], nums[j]-arr[j-1]);
            }
        }
        if(arr[len-1]>=0){
            return true;
        }
        return false;
    }
}