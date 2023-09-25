package Day249;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class maxSumCombination {

    public static List<Integer> maxCombinations(int n, int k, int A[], int B[]) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=n-1; i>n-k-1; i--) {
            for (int j=n-1; j>n-k-1; j--) {
                int temp = A[i] + B[j];
                if (pq.size() < k) {
                    pq.offer(temp);
                } else {
                    if (pq.peek()<temp) {
                        pq.poll();
                        pq.offer(temp);
                    } else {
                        break;
                    }
                }
            }
        }

        if (!pq.isEmpty()) {
            answer.add(pq.poll());
        }
        while (!pq.isEmpty()) {
            answer.add(0, pq.poll());
        }

        return answer;
    }

    public static  void main(String[] args) {
        int arr1[] = {3, 2};
        int arr2[] = {1, 4};
        int n1 = 2, k1 = 2;
        int n2 = 4, k2 = 3;
        int arr3[] = {1,4,2,3};
        int arr4[] = {2,5,1,6};
        System.out.println(maxCombinations(n1, k1, arr1, arr2));
        System.out.println(maxCombinations(n2, k2, arr3, arr4));
    }
}