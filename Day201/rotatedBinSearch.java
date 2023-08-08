package Day201;

public class rotatedBinSearch{
    public static void main(String[] args){
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }
    public static int search(int arr[], int target){
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = high - ((high-low)>>1);
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid]>=arr[low]){
                if(arr[low]<=target && target<arr[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(target<=arr[high] && target>arr[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}