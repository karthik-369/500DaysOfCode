package Day235;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Solution {
     public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<groupSizes.length; i++) {
            int len = groupSizes[i];
            map.putIfAbsent(len, new ArrayList<>());
            map.get(len).add(i);
            if(map.get(len).size() == len) {
                list.add(new ArrayList<>(map.get(len)));
                map.get(len).clear();
            }
        }
       
        return list;
    }
    // public List<List<Integer>> groupThePeople(int[] groupSizes) {
    //     List<List<Integer>> list = new ArrayList<>();
    //     Map<Integer, List<Integer>> map = new TreeMap<>();
    //     for (int i=0; i<groupSizes.length; i++) {
    //         if (!map.containsKey(groupSizes[i])) {
    //             map.put(groupSizes[i], new ArrayList<>());
    //         }
    //     }
    //     for (int i=0; i<groupSizes.length; i++) {
    //         map.get(groupSizes[i]).add(i);
    //     }
    //     for (int key: map.keySet()) {
    //         int temp = 0;
    //         List<Integer> l = new ArrayList<>();
    //         int count = 0;
    //         for (int i=0; i<map.get(key).size(); i++) {
    //             l.add(map.get(key).get(temp++));
    //             count++;
    //             if (count == key) {
    //                 list.add(new ArrayList<>(l));
    //                 l.clear();
    //                 count = 0;
    //             }
    //         }
    //     }
    //     // System.out.println(map);
    //     return list;
    // }
}