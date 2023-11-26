//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    List<Integer> answer;
    int n;
    public void print( int N) {
        answer.add(n);
        if (n<=0) {
           return;
        }
        n-=5;
        print(N);
    }
    public void nprint( int N) {
        answer.add(n);
        if (n>=N) {
            return;
        }
        n+=5;
        nprint( N);
    }
    public List<Integer> pattern(int N){
        // code here
        answer = new ArrayList<>();
        if (N == 0) {
            answer.add(0);
            return answer;
        }
        if (N<0) {
            answer.add(N);
            return answer;
        }
        n = N;
        print( N);
        n+=5;
        nprint(N);
        return answer;
    }
}