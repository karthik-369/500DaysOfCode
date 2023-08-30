class Solution {
    public long minimumReplacement(int[] nums) {
        int len = nums.length;
        int e = nums[len-1];
        long answer = 0;
        for (int i=len-2; i>=0; i--) {
            if (nums[i] > e) {
                int temp = nums[i]/ e;
                if (nums[i] % e !=0) {
                    temp++;
                }   
                e = nums[i]/temp;
                answer += temp -1;
            } else {
                e = nums[i];
            }
            
        }
        return answer;
    }
}