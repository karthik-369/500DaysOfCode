package Day352;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

// import javax.swing.RowFilter.ComparisonType;
// 
class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class MaximumPorfitInJpobSchduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int dp[][] = new int[n][3];
        for (int i=0; i<n; i++ ) {
            dp[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(dp, (a,b)->a[1]-b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int temp[]: dp) {
            int c = map.floorEntry(temp[0]).getValue() + temp[2];
            if (c > map.lastEntry().getValue()) {
                map.put(temp[1], c);
            }
        }
        return map.lastEntry().getValue();
    }
    public static void main(String[] args) {
        int st1[] = {1,2,3,3};
        int et1[] = {3,4,5,6};
        int p1[] = {50, 10, 40, 70};
        int st2[] = {1,2,3,4,6};
        int et2[] = {3,5,10,6, 9};
        int p2[] = {20, 20, 100, 70, 60};
        int st3[] = {1,1,1};
        int et3[] = {2,3,4};
        int p3[] = {5,6,4};
        System.out.println(jobScheduling(st1, et1, p1));
        System.out.println(jobScheduling(st2, et2, p2));
        System.out.println(jobScheduling(st3, et3, p3));
    }
}