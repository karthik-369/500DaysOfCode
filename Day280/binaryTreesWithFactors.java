package Day280;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class binaryTreesWithFactors {
    public static int numFactoresBinaryTrees(int arr[]) {
        int mod = 1000000007;
        Arrays.sort(arr);
        long[] a = new long[arr.length];
        Arrays.fill(a, 1);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int temp = arr[i] / arr[j];
                    if (m.containsKey(temp)) {
                        a[i] = (int) ((a[i] + (long) a[j] * a[m.get(temp)]) % mod);
                    }
                }
            }
        }
        int answer = 0;
        for (long v : a) {
            answer = (int) ((answer + v) % mod);
        }
        return answer;
    }
    public static void main(String[] args) {
        int arr1[] = {2,4};
        int arr2[] = {2,4,5,10};
        int arr3[] = {18,3,6,2};
        System.out.println(numFactoresBinaryTrees(arr1));
        System.out.println(numFactoresBinaryTrees(arr2));
        System.out.println(numFactoresBinaryTrees(arr3));
    
    }
}