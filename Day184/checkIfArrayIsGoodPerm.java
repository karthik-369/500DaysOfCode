class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            max = Math.max(max, i);
        }
        int arr[] = new int[max+1];
        for(int i:nums){
            arr[i]++;
        }
        if(arr[max]!=2){
            return false;
        }
        for(int i=1;i<max;i++){
            if(arr[i]!=1){
                return false;
            }
        }
        return true;
    }
}