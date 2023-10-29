class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int temp = minutesToTest/minutesToDie;
        int i=0;
        while (Math.pow(temp+1, i) < buckets) {
            i++;
        }
        return i;
    }
}