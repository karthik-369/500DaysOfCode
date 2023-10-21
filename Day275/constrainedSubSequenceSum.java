package Day275;

import java.util.Arrays;
import java.util.PriorityQueue;

public  class constrainedSubSequenceSum {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int len = nums.length;
        int arr[] = new int[len];
        int answer = nums[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->arr[b]-arr[a]);
        Arrays.fill(arr, Integer.MIN_VALUE);
        arr[0] = nums[0];
        priorityQueue.offer(0);
        for (int i=1; i<len; i++) {
            int j = Math.max(i-k,0);
            while (!priorityQueue.isEmpty() &&priorityQueue.peek()<j) {
                priorityQueue.poll();
            }
            int ind = priorityQueue.peek();
            arr[i] = Math.max(arr[ind] + nums[i], nums[i]);
            answer = Math.max(answer, arr[i]);
            priorityQueue.offer(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int k1 = 2;
        int k2 = 2;
        int k3 = 3;
        int nums1[] = {10,2, -10, 5, 20};
        int nums2[] = {-1,-2, -2};
        int nums3[] = {10,-2, -10, -5,20};
        System.out.println(constrainedSubsetSum(nums1, k1));
        System.out.println(constrainedSubsetSum(nums2, k2));
        System.out.println(constrainedSubsetSum(nums3, k3));

    }
}