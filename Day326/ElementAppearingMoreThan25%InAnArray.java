class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = arr.length/4;
        for (int i=0; i<arr.length-count; i++) {
            if (arr[i] == arr[i+count]) {
                return arr[i];
            }
        }
        return -1;
    }
}