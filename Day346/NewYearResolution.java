package Day346;

import java.util.Arrays;

public class NewYearResolution {
    public static int dp[][] = new int[367][2025];
    public static boolean solve(int i, int temp, int arr[], int n) {
        if (temp != 0 && (temp %20 == 0 || temp %24==0 || temp == 24)) {
            return true;
        }
        if (i >= n || temp > 2024) {
            return false;
        }
        if (dp[i][temp] != -1 ) {
            return dp[i][temp] == 1?true:false;
        }
        boolean t = solve(i+1, temp+arr[i], arr, n) || solve(i+1, temp, arr, n);
        dp[i][temp] = t?1:0;
        return t; 
    }
    public static boolean isPossible(int arr[], int n) {
        for (int i=0; i<367; i++) {
            Arrays.fill(dp[i], -1);
        }
        int temp = 0 ;
        return solve(0, temp, arr, n);
    }
    public static void main(String[] args) {
        int arr1[] = {5, 8, 9, 10, 14, 2, 3, 5};
        int n1 = 8;
        int arr2[]= {1,2,3,4,5};
        int n2 = 5;           
        System.out.println(isPossible(arr1, n1));
        System.out.println(isPossible(arr2, n2));
    }
}