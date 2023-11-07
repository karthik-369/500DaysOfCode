class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
       double arr[] = new double[dist.length];
       for (int i=0; i<dist.length; i++) {
           arr[i] = (double)dist[i]/ speed[i];
       }
       Arrays.sort(arr);
       for (int i=0; i<dist.length; i++) {
           if (arr[i]<=(double)i) {
               return i;
           }
       }
       return dist.length;
    }
}