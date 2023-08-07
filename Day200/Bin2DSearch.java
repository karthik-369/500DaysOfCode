package Day200;

public class Bin2DSearch{
    public static void main(String[] args){
        int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 40;
        System.out.println(searchMatrix(mat, target));
    } 

    public static boolean searchMatrix(int[][] mat, int target){
        for(int temp[]: mat){
            int low = 0;
            int high = temp.length-1;
            while(low<=high){
                int mid = high - (high - low)/2;
                if(temp[mid] == target){
                    return true;
                }
                if(temp[mid]>target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return false;
    } 
}