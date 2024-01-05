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
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int nthPoint(int n)
    {
        // Code here
        if (n == 1) {
            return 1;
        }
        int a = 2;
        int b = 3;
        if (n == 2) {
            return a;
        }
        if (n == 3) {
            return b;
        }
        for (int i=4; i<=n; i++) {
            int temp = (a + b)%1000000007;
            a = b;
            b = temp;
        }
        return b;
    }
}