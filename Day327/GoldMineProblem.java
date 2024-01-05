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
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static int dir[][] = {{-1,-1}, {0,-1}, {1,-1}};
    static int maxGold(int n, int m, int M[][]) {
        int arr[][] = new int[n][m];
        for (int i=0; i<n; i++) {
            arr[i][0] = M[i][0];
        }
        for (int i=1; i<m; i++) {
            for (int j=0;j<n; j++) {
                int temp = Integer.MIN_VALUE;
                for (int k=0; k<3; k++) {
                    int x = j+ dir[k][0];
                    int y = i + dir[k][1];
                    if (x>=0 && x<n && y>=0 && y<m) {
                        temp = Math.max(temp, arr[x][y] + M[j][i]);
                    }
                }
                arr[j][i] = temp;
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            answer = Math.max(answer, arr[i][m-1]);
        }
        return answer;
    }

     
}