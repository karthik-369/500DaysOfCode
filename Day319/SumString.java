//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isSumString(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public int isSumString(String S){
        // code here
        for (int i=1; i<S.length(); i++) {
            for (int j=1; j<S.length()-i; j++) {
                if (find(S, 0, i, j)) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public boolean find(String s, int pos, int i, int j) {
        String temp1 = s.substring(pos, pos+i);
        String temp2 = s.substring(pos+i, pos+j+i);
        String temp3 = sum(temp1, temp2);
        if (temp3.length() > s.length() - pos - i - j) {
            return false;
        }
        if (s.substring(pos+i+j, pos+i+j+temp3.length()).equals(temp3)) {
            if (pos + i + j + temp3.length() == s.length()) {
                return true;
            }
            return find(s, pos+i, j, temp3.length());
        }
        return false;
    }
    public String sum(String s1, String s2) {
        int i = s1.length()-1, j = s2.length()-1;
        StringBuilder answer = new StringBuilder();
        int c = 0;
        while (i >= 0 && j >= 0) {
            int x = s1.charAt(i)-'0';
            int y = s2.charAt(j)-'0';
            int temp = x + y + c;
            int rem = temp%10;
            c = temp/10;
            answer.append(rem);
            i--;
            j--;
        }
        while (i>=0) {
            int x = s1.charAt(i)-'0';
            int temp = x + c;
            int rem = temp%10;
            c = temp/10;
            answer.append(rem);
            i--;
        }
        while (j>=0) {
            int x = s2.charAt(j)-'0';
            int temp = x + c;
            int rem = temp%10;
            c = temp/10;
            answer.append(rem);
            j--;
        }
        while (c>0) {
            int rem = c % 10;
            answer.append(rem);
            c/=10;
        }
        return answer.reverse().toString();
    }
}