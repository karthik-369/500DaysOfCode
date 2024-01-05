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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        long arr1[] = new long[N+1];
        long arr2[] = new long[N+1];
        arr1[1] = 1;
        arr2[1] = 1;
        int mod = 1000000007;
        for (int i=2; i<=N; i++) {
            arr2[i] = (arr1[i-1] + arr2[i-1]) % mod;
            arr1[i] = arr2[i-1];
        }
        long answer = (arr1[N] + arr2[N]) % mod;
        return (int)((answer * answer) % 1000000007);
    }
}