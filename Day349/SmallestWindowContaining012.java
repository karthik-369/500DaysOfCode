//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int z=0, o=0,t=0;
        int answer = Integer.MAX_VALUE;
        int j =0;
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == '0') {
                z++;
            } else if (S.charAt(i) =='1') {
                o++;
            } else {
                t++;
            }
            while (z>0 && o>0 && t>0) {
                answer = Math.min(answer, i-j+1);
                if (S.charAt(j) =='0') {
                    z--;
                } else if (S.charAt(j) == '1') {
                    o--;
                } else {
                    t--;
                }
                j++;
            }
        }
        return answer==Integer.MAX_VALUE?-1: answer;
    }
};
