package Day239;

import java.util.Arrays;

public class partitionEqualSubsetSum {

    public static int kn[][];
    
    public static boolean isSub(int arr[], int n, int pos, int sum) {
        if (sum == 0) {
            return true;
        } else if ( pos >= n || sum < 0) {
            return false;
        }
        if (kn[pos][sum] != -1) {
            return kn[pos][sum]==1?true:false;
        }
        boolean dec = (isSub(arr, n, pos+1, sum - arr[pos]) || isSub(arr, n, pos+1, sum));
        kn[pos][sum] = dec?1:0;
        return dec;
    }

    public static int equalPartition(int n, int arr[]) {
        
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];
        }

        if ((sum & 1 )== 1) {
            return 0;
        }

        kn = new int[n+1][sum/2+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(kn[i], -1);
        }

        if (isSub(arr, n, 0, sum/2)) {
            return 1;
        }

        return 0;
    }
    
    public static void main(String[] args) {
        int n = 4;
        int arr[] = {1,5,11, 5};
        System.out.println(equalPartition(n , arr));
    }

}