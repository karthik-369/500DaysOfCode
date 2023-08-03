package Day196;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int temp[]: matrix){
            int low = 0;
            int high = matrix[0].length-1;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(temp[mid] == target){
                    return true;
                }
                if(temp[mid]>target){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
            }
        }
        return false;
    }
}