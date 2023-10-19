package Day273;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOfNodes {
    public static List<List<Integer>> create(int n, int mat[][]) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            answer.add(new ArrayList<>());
        }
        for (int i=0; i<mat.length; i++) {
            answer.get(mat[i][0]).add(mat[i][1]);
        }
        return answer;
    }

    public static int nodeLevel(int v, List<List<Integer>> adj, int x) {
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        queue.offer(new int[]{0,0});
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] temp =queue.poll();
            if (temp[0] == x) {
                return temp[1];
            }
            for (int i: adj.get(temp[0])) {
                if (!visited[i]) {
                    queue.offer(new int[]{i, temp[1]+1});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n1 = 6;
        int mat1[][] = { {0,1},{0,2},{1,0}, {1,3}, {1,4},{2,0}, {2,5}, {3,1}, {4,1}, {5,2}};
        int x1 = 4;
        int n2 = 4;
        int mat2[][] = {{0,1},{0,2},{0,3}, {1,0}, {2,0}, {3,0}};
        int x2 = 1;
        List<List<Integer>> adj1 = create(n1, mat1);
        List<List<Integer>> adj2 = create(n2, mat2);
        System.out.println(nodeLevel(n1, adj1, x1));
        System.out.println(nodeLevel(n2, adj2, x2));
        // System.out.println(adj1);
        // System.out.println(adj2);
    }
}