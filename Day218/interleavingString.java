package Day218;

import java.util.Arrays;

public class interleavingString {

    public static boolean dfs(String s1, String s2, String s3, int i, int j, int k, int l1, int l2, int l3, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j] ==1;
        }
        if (i == l1 && j == l2 && k == l3) {
            return true;
        }
        boolean left = false, right = false;
        if (i != l1 && s1.charAt(i) == s3.charAt(k)) {
            left = dfs(s1, s2, s3, i+1, j, k+1, l1, l2, l3, dp);
        }
        if(j != l2 && s2.charAt(j) == s3.charAt(k)) {
            right = dfs(s1, s2, s3, i, j+1, k+1, l1, l2, l3, dp);
        }
        dp[i][j] = (left||right)?1:0;
        return left||right;
    }
    
    public static boolean interstr(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1+l1!=l3) {
            return false;
        }
        int dp[][] = new int[l1+1][l2+1];
        for (int i=0; i<=l1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(s1, s2, s3, 0, 0, 0, l1, l2, l3, dp);
    }

    public static void main(String[] args) {
        String s1 = "aabccd";
        String s2 = "dbbcad";
        String s3 = "aadbbcbcaddc";
        System.out.println(interstr(s1, s2 ,s3));
    }
}