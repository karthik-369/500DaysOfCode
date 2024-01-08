package Day353;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AritmeticSlicesII {
    public static int numberOfArithmeticSlices(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int dp[][] = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            long temp  = (long)nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(i);
        }
        for (int i=1; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                long temp  = (long)(2*(long)nums[i]) - (long)nums[j];
                if (map.containsKey(temp)) {
                    for (int v : map.get(temp)) {
                        if (v < i) {
                            dp[i][j] += dp[v][i] + 1;
                        } else {
                            break;
                        }
                    }
                }
                answer += dp[i][j];
            }
        }
        System.out.println(map);
        return answer;
    }
    public static void main(String[] args) {
        int arr1[] = {2,4,6,8, 10};
        int arr2[] = {7,7,7,7,7};
        System.out.println(numberOfArithmeticSlices(arr1));
        System.out.println(numberOfArithmeticSlices(arr2));
    }
}