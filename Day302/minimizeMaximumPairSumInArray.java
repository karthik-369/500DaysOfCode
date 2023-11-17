class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int i =0, j= nums.length-1;
        while (i<j) {
            answer = Math.max(answer, nums[i++]+nums[j--]);
        }   
        return answer;
    }
}