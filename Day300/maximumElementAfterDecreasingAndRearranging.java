class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int l = arr.length;
        int temp[] = new int[l];
        for (int i=0; i<l; i++) {
            temp[Math.min(arr[i]-1, l-1)]++;
        }   
        int answer = 1;
        for (int i=1; i<l; i++) {
            answer = Math.min(i+1, answer+temp[i]);
        }
        return answer;
    }
}