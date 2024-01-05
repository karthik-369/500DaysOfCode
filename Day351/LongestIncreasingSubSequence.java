class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n]; 
        int answer = 1;
        arr[0] = 1;
        for (int i=1; i<n; i++) {
            arr[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    arr[i] = Math.max(arr[i], arr[j]+1);
                }
            }
            answer = Math.max(answer, arr[i]);
        }
        return answer;
    }
}