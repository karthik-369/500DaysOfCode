class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = nums[0], max2 = Integer.MIN_VALUE, min1 = nums[0], min2 = Integer.MAX_VALUE;
        for (int i=1; i<nums.length; i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
        }
        return max1*max2 - min1 * min2;
    }
}