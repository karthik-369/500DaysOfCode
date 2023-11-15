//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        return func(str1)>=func(str2)?str1:str2;
    }
    public static int func(String s) {
        int visited[] = new int[26];
        long arr[] = new long[s.length()+1];
        int mod = 1000000007;
        arr[0] = 1;
     
        for (int i=1; i<=s.length(); i++) {
            arr[i] = (arr[i-1]*2)%mod;
            if (visited[s.charAt(i-1)-'a']!=0) {
                arr[i] = (arr[i]- arr[visited[s.charAt(i-1)-'a']-1] + mod) %mod;
            }
            visited[s.charAt(i-1)-'a'] = i;
        }
        return (int)arr[s.length()];
    }
}