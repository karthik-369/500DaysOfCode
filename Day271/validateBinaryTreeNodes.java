package Day271;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class validateBinaryTreeNodes {
    public static boolean VBTN(int n, int left[], int right[]) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> root = new HashSet<>();
        boolean visited[] = new boolean[n];
        for (int i=0; i<n; i++) {
            if (left[i] != -1) {
                root.add(left[i]);
            }
        }
        for (int i=0; i<n; i++) {
            if (right[i] != -1) {
                root.add(right[i]);
            }
        }
        int r = -1;
        for (int i=0; i<n; i++) {
            if (!root.contains(i)) {
                r = i;
                break;
            }
        }
        if (r == - 1) {
            return false;
        }

        queue.offer(r);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (visited[num]) {
                return false;
            }
            visited[num] = true;
            if (left[num] != -1 ) {
                queue.offer(left[num]);
            }
            if (right[num] != -1) {
                queue.offer(right[num]);
            }
        }
        int len = 0;
        for (int i=0; i<n; i++) {
            if (visited[i]) {
                len++;
            }
        }
        return len == n;
    }
    public static void main(String[] args) {
        int n1 = 4;
        int left1[] = {1,-1,3,-1};
        int right1[] = {2,-1,-1, -1};
        int n2 = 4;
        int left2[] = {1,-1, 3, -1};
        int right2[] = {2,3,-1,-1}; 
        int n3 = 4;
        int left3[] = {3,-1,1,-1};
        int right3[] = {-1,-1,0,-1};
        System.out.println(VBTN(n1, left1, right1));
        System.out.println(VBTN(n2, left2, right2));
        System.out.println(VBTN(n3, left3, right3));

    }
}