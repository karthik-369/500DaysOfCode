package Day209;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;
public class maxInSlideWindow {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (k == 1) {
            return arr;
        }

        int answer[] = new int[arr.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<arr.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
             }
            while (!deque.isEmpty() && arr[deque.peekLast()]<arr[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k - 1) {
                answer[i - k + 1] = arr[deque.peek()];
            }
        }
        return answer;
        
    }
    public static void main(String[] args) {
        int arr[] = {1 , 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow( arr, k)));
    }
}