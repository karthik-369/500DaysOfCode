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
            
            String input_line[] = br.readLine().trim().split("\\s+");
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(input_line[i * n + j]); 
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.antiDiagonalPattern(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int pointer = 0;
    public void diagonal(int matrix[][], int answer[], boolean visited[][], int i, int j) {
        if (i<0 || j<0 || j>=matrix[0].length || i>=matrix.length) {
            return;
        }
        answer[pointer++] = matrix[i][j];
        visited[i][j] = true;
        diagonal(matrix, answer, visited, i+1, j-1);
    }
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code here
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        int answer[] = new int[matrix.length*matrix.length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (!visited[i][j]) {
                    diagonal(matrix, answer, visited, i , j);
                }
            }
        }
        return answer;
    }
}