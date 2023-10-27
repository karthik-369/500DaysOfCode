class Solution {
    public String longestPalindrome(String s) {
        int answer = 0;
        int l =0, h = 0;
        int le = s.length();
        for (int i=1; i<le; i ++) {
            int sp= i -1, ep = i+1;
            while  ((sp>=0 && ep<le) && (s.charAt(sp) == s.charAt(ep))) {
                if (ep-sp+1 > answer) {
                    answer = ep-sp+1;
                    l = sp;
                    h = ep;
                }
                sp--;
                ep++;
            }
            sp = i-1;
            ep = i;
            while ((sp>=0 && ep<le) && (s.charAt(sp) == s.charAt(ep))) {
                if( ep-sp+1 > answer) {
                    answer = ep-sp+1;
                    l = sp;
                    h = ep;
                }
                sp--;
                ep++;
            }    
        }
        StringBuilder ans = new StringBuilder();
        for (int i=l; i<=h; i++) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}