//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        int len = S.length();
        int arr[][] = new int[len+1][len+1];
        StringBuilder sb = new StringBuilder(S);
        sb = sb.reverse();
        for (int i=0; i<=len; i++) {
            for (int j=0; j<=len; j++) {
                if (i == 0 || j == 0 ) {
                    arr[i][j] = 0;
                } else if (S.charAt(i-1) == sb.charAt(j-1)) {
                    arr[i][j] = 1 + arr[i-1][j-1];
                } else {
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                }
            }
        }
        return len - arr[len][len];
    }
}