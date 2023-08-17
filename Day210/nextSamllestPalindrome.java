//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    boolean right(int[] num, int n) {
        int i = (n-1) / 2;
        int j = n / 2;
        while (i >= 0 && j < n) {
            if (num[i] < num[j]) {
                return true;
            } else if (num[i] > num[j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    
    boolean check(int[] num, int n) {
        for (int i=0; i<n; i++) {
            if (num[i] != 9) {
                return false;
            }
        }
        return true;
    }
    
    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        Vector<Integer> answer = new Vector<>();
        if (check(num, n)) {
            for (int i=0; i<n+1; i++) {
                if (i == 0 || i == n) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
            }
            return answer;
        }
        
        boolean flag = right(num, n);
        int i = (n-1)/2;
        int j = n / 2;
        while (i >= 0) {
            if (flag) {
                if (num[i] == 9) {
                    num[i] = 0; 
                } else {
                    num[i]++;
                    flag = false;
                }
            }
            num[j++] = num[i--];
        }
        for (i=0; i<n; i++) {
            answer.add(num[i]);
        }
        return answer;
    }
}