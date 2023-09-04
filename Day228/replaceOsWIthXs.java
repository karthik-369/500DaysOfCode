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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        for (int i=0; i<n; i++) {
            if (a[i][0] == 'O') {
                dfs(i, 0, a, n, m);
            }
            if (a[i][m-1] == 'O') {
                dfs(i, m-1, a, n, m);
            }
            for (int j=0; j<m; j++) {
                if (a[0][j] == 'O') {
                    dfs(0, j, a, n, m);
                }
                if (a[n-1][j] == 'O') {
                    dfs(n-1, j, a, n, m);
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                }
                if (a[i][j] == '.') {
                    a[i][j] = 'O';
                }
            }
        }
        return a;
    }
    
    public static void dfs(int i, int j, char a[][], int r, int c) {
        if (i<0 || j<0 ||i>=r ||j >=c || a[i][j] == 'X') {
            return;
        }
        if (a[i][j] == 'O') {
            a[i][j] = '.';
            dfs(i-1, j , a, r, c);
            dfs(i+1, j , a, r, c);
            dfs(i, j-1 , a, r, c);
            dfs(i, j+1 , a, r, c);
        }
    }
    
}