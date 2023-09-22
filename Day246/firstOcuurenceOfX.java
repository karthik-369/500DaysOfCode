
package Day246;

import java.util.ArrayList;

public class firstOcuurenceOfX {

   public static ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        int low = 0, high = n-1;
        ArrayList<Integer> answer = new ArrayList<>();
        while (low <= high) {
            int mid = high - ((high - low)>>1);
             
            
            if (arr[mid] == x) {
                
                
                while (mid >=1 && arr[mid-1]==x) {
                    mid--;
                }
                answer.add(mid);
                while(mid<n-1 && arr[mid+1]==x) {
                    mid++;
                }
                answer.add(mid);
                return answer;
            }
            else if (x >arr[mid]){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        answer.add(-1);
        answer.add(-1);
        return answer;
    }

    public static void main(String[] args) {
        int n = 9;
        int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        System.out.println(find(arr, n , x));
    }
}