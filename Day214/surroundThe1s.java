package Day214;
//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
class surroundThe1s
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int answer = 0;
        int r= matrix.length;
        int c = matrix[0].length;
        int dir[][] = {{-1,-1},{-1, 0},{-1,1},{0,-1},{0,1},{1,-1},{1,0}, {1,1}};
        for (int i=0; i<r; i++) {
            
            for (int j=0; j<c; j++) {
                int oc = 0;
                if (matrix[i][j] == 1) {
                    for (int[] d: dir) {
                        int x = i+d[0];
                        int y = j+d[1];
                        if (x>=0 && y >=0 && x<r && y<c && matrix[x][y] == 0) {
                            // System.out.println(x+" "+y);
                            oc++;
                        }
                    }  
                }
                if(oc!=0 && oc%2==0) {
                    answer++;
                }
                
            }
        }
        return answer;
    }
}