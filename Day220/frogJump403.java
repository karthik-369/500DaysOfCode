package Day220;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class frogJump403 {

    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i<stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for (int i=0; i<stones.length; i++) {
            int curr = stones[i];
            Set<Integer> stoneOrWater = map.get(stones[i]);
            for (int itr : stoneOrWater) {
                int pos = itr+ curr;
                if (pos == stones[stones.length-1]) {
                    return true;
                }
                if (map.containsKey(pos)) {
                    if (itr - 1 > 0) {
                        map.get(pos).add(itr - 1);
                    }
                    map.get(pos).add(itr+1);
                    map.get(pos).add(itr);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int stones[] = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}