package Day237;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;

class largestNumberPossible{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            temp ob = new temp();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class temp{
    static String findLargest(int N, int S){
        // code here
        if (N*9<S || (S==0 && N>1)) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        int i = 9;
        while (N > 0) {
            if (arr[i]>S) {
                i--;
            } else if (arr[i] <= S) {
                S -= arr[i];
                sb.append(arr[i]);
                N--;
            }
        }
        if(sb.length() == 0 || S!=0) {
            return "-1";
        }
        return sb.toString();
    }
}