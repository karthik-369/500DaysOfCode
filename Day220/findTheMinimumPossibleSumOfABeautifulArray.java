package Day220;

import java.util.Set;
import java.util.HashSet;
class findTheMinimumPossibleSumOfABeautifulArray {
    public long minimumPossibleSum(int n, int target) {
        Set<Integer> set = new HashSet<>();
        long answer = 0;
        for (int i=1; set.size()<n; i++) {
            if (!set.contains(target - i)) {
                set.add(i);
                answer+=i;
            }
        }
        return answer;
    }
}