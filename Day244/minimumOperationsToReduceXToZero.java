class Solution {
    public int minOperations(int[] nums, int targetSum) {
        int temp = 0;
        for (int i=0; i<nums.length; i++) {
            temp += nums[i];
        }
        int t = temp - targetSum;
        if (t == 0) {
            return nums.length;
        }
        if (t<0) {
            return -1;
        }
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        int curr = 0, li = 0, ri = 0;
        while (ri < n) {
            curr += nums[ri];
            ri++;
            while (curr > t && li < n) {
                curr -= nums[li];
                li++;
            }
            if (curr == t) {
                answer = Math.min(answer, n-(ri - li));
            }
        }
        if (answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }
}