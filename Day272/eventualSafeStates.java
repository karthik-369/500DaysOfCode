package Day272;

import java.util.ArrayList;
import java.util.List;

import Day254.booleanMatrix;

public class eventualSafeStates {
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
    public static List<Integer> ESS(int V, List<List<Integer>> adj) {
        List<Integer> answer =  new ArrayList<>();
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];
        boolean temp[] = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, path, temp);
            }
        }
        for (int i=0; i<V; i++) {
            if (temp[i]) {
                answer.add(i);
            }
        }
        return answer;
    }

    private static boolean dfs(int i ,List<List<Integer>> adj, boolean visited[], boolean path[], boolean temp[]) {
        visited[i] = true;
        path[i] = true;
        temp[i] = false;
        for (int n : adj.get(i)) {
            if (!visited[n]) {
                if (dfs(n, adj, visited, path, temp)) {
                    return true;
                }
            } else if (path[n]) {
                return true;
            }
        }
        temp[i] = true;
        path[i] = false;
        return false;
    }
    public static void main(String[] args) {
        int n1 = 7;
        int mat1[][] = { {0,1},{0,2}, {1,2}, {1,3}, {2,5}, {3,0}, {4,5}};
        int n2 = 4;
        int mat2[][] = {{0,1}, {1,2}, {2,0}, {2,3}};
        List<List<Integer>> adj1 = create(n1, mat1);
        List<List<Integer>> adj2 = create(n2, mat2);
        System.out.println(ESS(n1, adj1));
        System.out.println(ESS(n2, adj2));
    }
}