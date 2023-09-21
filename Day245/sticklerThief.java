package Day245;

public class sticklerThief {

    public static int findMaxSum(int arr[], int n) {
        int curr = 0, prev = 0;
        for (int i=0; i<n; i++) {
            int temp = Math.max(prev + arr[i], curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int arr[] = {6,5,5,7,4};
        System.out.println(findMaxSum(arr, 5));

    }
}