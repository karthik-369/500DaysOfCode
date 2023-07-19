Bobble BackgroundBobble Head
Problems
Courses
Geek-O-Lympics
Events
POTD

Refresh

Time (IST)	Status	Lang	Test Cases	Code
2023-07-19 09:39:59	Correct	java	1120 / 1120	View
Java (1.8)




Custom Input


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder s = new StringBuilder(S);
        String reverse = s.reverse().toString();
        int len = S.length();
        int arr[][] = new int[len+1][len+1];
        for(int i=0;i<=len;i++){
            
            for(int j=0;j<=len;j++){
                if(i>0 && j>0){
                    if(S.charAt(i-1)==reverse.charAt(j-1)){
                        arr[i][j] = arr[i-1][j-1]+1;
                    }else
                    {
                        arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                    }
                }
            }
        }
        return arr[len][len];
    }
}