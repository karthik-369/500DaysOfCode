package Day237;

import java.util.Arrays;

public class Candy135 {

    public static int candy(int []ratings) {
        int answer = 0;
        int n = ratings.length;
        int arr[] = new int[n];
        Arrays.fill(arr, 1);
        for (int i=1; i<n; i++) {
            if (ratings[i-1]<ratings[i] && arr[i-1]>=arr[i]) {
                arr[i] = arr[i-1]+1;
            }
        }
        for (int i=n-2; i>=0; i--) {
            if (ratings[i+1]<ratings[i] && arr[i+1]>=arr[i]) {
                arr[i] = arr[i+1]+1;
            }
        }
        for (int j=0; j<n; j++) {
            answer += arr[j];
        }
        return answer;

    }
    public static void main(String[] args) {
        int nums[] = {1,0,2,5,6,4,5};
        System.out.println(candy(nums));
    }
}