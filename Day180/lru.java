// gfg longestRepeatingSubsequence
//dp
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int len = str.length();
        int arr[][] = new int[len+1][len+1];
        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>=0;j--){
                if(str.charAt(i)==str.charAt(j)&&i!=j){
                    arr[i][j] = 1 + arr[i+1][j+1];
                }else{
                    arr[i][j] = Math.max(arr[i+1][j], arr[i][j+1]);
                }
            }
        }
        return arr[0][0];
    }
}