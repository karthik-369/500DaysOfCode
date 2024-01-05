class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        int i = s.length-1;
        int c = g.length-1;
        while( i >=0 && c >= 0) {
            if (s[i]  >= g[c]) {
                max++;
                i--;
                c--;
            } else {
                c--;
            }
        } 
        return max;
    }
}