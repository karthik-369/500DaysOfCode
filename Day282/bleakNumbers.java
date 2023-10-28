//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
        // Code here
        if (n <= 32) {
            for (int i=1; i<=32; i++) {
                int count = 0;
                for (int j=0; j<32; j++) {
                    if (((1<<j) & i) >= 1) {
                        count++;
                    }
                }
                if (count +i == n) {
                    return 0;
                }
                
            }
            return 1;
        } else {
            int temp = n - 32;
            for (int i=temp; i<=n ;i++) {
                int count = 0;
                for (int j=0; j<32; j++) {
                    if (((1<<j) &i) >= 1) {
                        count++;
                    }
                    
                }
                if (count+i == n) {
                    return 0;
                }
                
            }
            return 1;
        }
        // return 0;
    }
}