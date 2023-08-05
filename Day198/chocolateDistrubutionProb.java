package Day198;
import java.util.Collections;
import java.util.ArrayList;
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i<n && (i+m-1<n)){
                min = Math.min(a.get(i+m-1)-a.get(i), min);
            }else{
                break;
            }
        }
        return min;
    }
}