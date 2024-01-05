package Day324;
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int fSum(int n) {
        int i =2, answer = 0;
        while (n > 1) {
            if (n % i == 0) {
                answer += dSum(i);
                n/=i;
            } else {
                do {
                    i++;
                }while (!isPrime(i));
            }
        }
        return answer;
    }
    public static boolean isPrime(int n) {
        if (n<=1) {
            return false;
        }
        for (int i=2; i*i<=n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int dSum(int n) {
        int answer = 0;
        while (n>0) {
            answer += n %10;
            n/=10;
        }
        return answer;
    }
    static int smithNum(int n) {
        // code here
        if ( isPrime(n) ) {
            return 0;
        }
        return dSum(n) == fSum(n)?1:0;
        
    }
    
    
};