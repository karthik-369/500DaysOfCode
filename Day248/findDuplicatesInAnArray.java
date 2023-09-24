package Day248;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class findDuplicatesInAnArray {

    public static List<Integer> duplicates(int arr[], int n) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i=0; i<n ; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        }
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                list.add(key);
            }
        }
        if (list.size() == 0){
            list.add(-1);
        }
         return list;
    }

    public static List<Integer> duplicatesII(int arr[], int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            arr[arr[i] %n] = arr[arr[i] %n] +n;
        }
        for (int i=0; i<n; i++) {
            if(arr[i]>= 2 * n) {
                answer.add(i);
            }
        }
        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,1,2,3};
        int n = 5;
        System.out.println(duplicates(arr, n));
        System.out.println(duplicatesII(arr, n));
    }
}