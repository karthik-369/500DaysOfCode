//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
    
    long numberOfPaths(int M, int N) {
        int Mod = 1000000007;
        long path = 1;
        for (int i = 0; i < M - 1; i++) {
            path = (path * (i + N)) % Mod;
            long temp = power(i + 1, Mod - 2, Mod);
            path = (path * temp) % Mod;
        }
        return (int) path;
    }
    private long power(long base, long exponent, int mod) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent /= 2;
        }
        return result;
    }
    
}