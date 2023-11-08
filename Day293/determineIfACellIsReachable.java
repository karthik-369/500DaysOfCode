class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx & fy == sy) {
            return t!=1;
        }
        return t>= Math.max(Math.abs(sx-fx), Math.abs(sy-fy));
    }
}