//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends


class Solution

{


    static int determinantOfMatrix(int matrix[][], int n)

    {


        if(n==1)return matrix[0][0];

        int ans=0;

        


        for(int i=0;i<n;i++){

            

            int[][] second=new int[n-1][n-1]; 

            


            for(int j=1;j<n;j++){

                int x=0;

                


                for(int k=0;k<n;k++){

                    if(k==i)continue; 

                    

                    second[j-1][x++]=matrix[j][k]; 

                }

            }

            ans+=matrix[0][i]*determinantOfMatrix(second,n-1)*((i&1)==1?-1:1); 

        }

        return ans;

    }

}

