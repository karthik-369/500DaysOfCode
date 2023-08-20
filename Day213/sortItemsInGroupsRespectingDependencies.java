package Day213;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    public int[] sort(Map<Integer, Set<Integer>> map) {
        Map<Integer, Integer> temp = new HashMap<>();
        for(Set<Integer> set : map.values()) {
            for(int i: set) {
                temp.merge(i, 1, Integer::sum);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int key: map.keySet()) {
            if (!temp.containsKey(key)) {
                queue.offer(key);
            }
        }
        int i =0;
        int answer[] = new int[map.size()];
        while(!queue.isEmpty()) {
            int t = queue.poll();
            answer[i++] = t;
            for(int n: map.get(t)) {
                if (temp.merge(n, -1, Integer::sum) == 0) {
                    queue.offer(n);
                }
            }
        }
        return i == answer.length ? answer: new int[]{};
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Map<Integer, Set<Integer>>> map = new HashMap<>();
        Map<Integer, Set<Integer>> smap = new HashMap<>();
        for (int i=0; i<n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        int answer[] = new int[n];
        for (int i=0; i<m; i++) {
            smap.put(i, new HashSet<>());
            map.put(i, new HashMap<>());
        }
        for(int i=0; i<n; i++) {
            map.get(group[i]).put(i, new HashSet<>());
        }
        for (int i=0; i<beforeItems.size(); i++) {
            for (int j=0; j<beforeItems.get(i).size(); j++) {
                if (group[i] == group[beforeItems.get(i).get(j)]) {
                    map.get(group[i]).get(beforeItems.get(i).get(j)).add(i);
                } else {
                    smap.get(group[beforeItems.get(i).get(j)]).add(group[i]);
                }
            }
        }
        int i=0;
        for (int temp:sort(smap)) {
            for (int j: sort(map.get(temp))) {
                answer[i++] = j;
            }
        }
        return i < answer.length ? new int[]{} : answer;
    }


}