//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int arr[][] = new int[N][N];
            
            for(int i = 0; i < N; i++)
            {
                int k = 0;
                String str[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < N; j++){
                  arr[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            
            System.out.println(new Solution().columnWithMaxZeros(arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        // code here 
        int temp[][] = new int[N][2];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 0) {
                    temp[j][0] = j;
                    temp[j][1]++;
                }
            }
            
        }
        Arrays.sort(temp, (a,b)-> {
            if (a[0] != b[0] ){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        return temp[0][1] == 0 ? -1 : temp[0][0];
        
    }
}