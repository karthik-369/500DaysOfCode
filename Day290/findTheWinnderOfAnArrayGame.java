class Solution {
    public int getWinner(int[] arr, int k) {
        int win = arr[0];
        int temp = 0; 
        for (int i=1; i<arr.length; i++) {
            if (win > arr[i]) {
                temp ++;
            } else {
                temp = 1;
                win = arr[i];
            }
            if (temp == k) {
                return win;
            }
        }
        return win;
    }
}