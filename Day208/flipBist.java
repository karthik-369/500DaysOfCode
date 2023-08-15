//{ Driver Code Starts
//Initial Template for Java


import java.io.*;

class flipBist {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int mc = 0;
        int cz = 0;
        int oc = 0;
        for(int i=0; i<n; i++ ) {
            if (a[i] == 0) {
                cz++;
            } else {
                cz--;
                oc++;
            }
            mc = Math.max(mc, cz);
            if(cz<0) {
                cz = 0;
            }
        }
        return mc+oc;
    }
}