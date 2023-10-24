//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int arr[];
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        arr = new int[n];
        Arrays.fill(arr, -1);
        return pal(0, n, str)-1;
    }
    static int pal(int ind, int n, String str) {
        if (ind == n) {
            return 0;
        }
        if (arr[ind] != -1) {
            return arr[ind];
        }
        int min = Integer.MAX_VALUE;
        for (int i=ind; i<n;  i++) {
            if (isPal(str, ind, i)) {
                min = Math.min(min, 1+pal(i+1, n, str));
            }
        }
        return arr[ind] = min;
    }
    static boolean isPal(String str, int i, int j) {
        while (i<j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}