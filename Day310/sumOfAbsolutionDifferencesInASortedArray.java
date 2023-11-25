class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int arr[] = new int[nums.length];
        int total = 0;

        for (int i=0; i<nums.length; i++) {
            total += nums[i];    
        }
        int l = 0, r = total;
        for (int i=0; i<nums.length; i++) {
            r -= nums[i];
            arr[i] = (r - l + (i*nums[i]) - (nums.length- i - 1) * nums[i]);
            l += nums[i];
        }
        return arr;
    }
}