//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        long answer = 0;
        for (long i=a;i<=b; i++) {
            answer += solve(i);
        }
        return answer;
    }
    public static long solve(long n) {
        long answer = 0;
        while (n %2 == 0) {
            answer ++;
            n/=2;
        }
        for (int i=3; i*i<=n; i++) {
            while (n%i == 0) {
                answer++;
                n/=i;
            }
        }
        if (n > 2) {
            answer++;
        }
        return answer;
    }
}
        
