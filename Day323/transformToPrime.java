//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
     class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testcases = Integer.parseInt(br.readLine());
            while (testcases-- > 0) {
                int n = Integer.parseInt(br.readLine());
                String line1 = br.readLine();
                String[] a1 = line1.trim().split("\\s+");
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(a1[i]);
                }
                Solution ob = new Solution();
                int ans=ob.minNumber(a,n);
                System.out.println(ans);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    
    class Solution
    {
        public boolean isPrime(int n) {
            for (int i=2; i<=Math.sqrt(n); i++) {
                if (n%i == 0) {
                    return false;
                }
            }
            return true;
        }
        public int minNumber(int arr[], int N)
        {
            int sum = 0;
            for (int i=0; i<N; i++) {
                sum += arr[i];
            }
            if (sum == 0) {
                return 0;
            }
            if (sum == 1) {
                return 1;
            }
            int temp = sum;
            while (!isPrime(sum)) {
                sum++;
            }
            return sum - temp;
        }
    }
    