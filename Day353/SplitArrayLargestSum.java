//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int solve(int arr[], int n, long max) {
        int count  =1; 
        long curr = 0;
        for (int num: arr) {
            curr += num;
            if (curr > max) {
                count++;
                curr = num;
            }
        }
        return count;
    }
    static int splitArray(int[] arr , int N, int K) {
        // code here
        long l = Arrays.stream(arr).max().getAsInt();
        long h = Arrays.stream(arr).sum();
        while (l < h) {
            long mid = l + (h - l) /2 ;
            int temp = solve(arr, N, mid);
            if (temp > K) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return (int)l;
    }
};