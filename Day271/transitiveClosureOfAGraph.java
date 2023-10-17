package Day271;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class transitiveClosureOfAGraph {

    public static List<List<Integer>> transitiveClosure(int n, int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
            answer.add(new ArrayList<>(Collections.nCopies(n, 0)));
            for (int j=0; j<n; j++) {
                if (graph[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        for (int i=0; i<n; i++) {
            dfs(i, i, new boolean[n], adj, answer);
        }
        return answer;
    }
    public static void dfs(int i, int j, boolean[] visited, List<List<Integer>> adj, List<List<Integer>> answer) {
        answer.get(i).set(j,1);
        visited[j] = true;
        for (int n: adj.get(j)) {
            if (!visited[n]) {
                dfs(i, n, visited, adj, answer);
            }
        }
    }
    public static void main(String[] args) {
        int n1 = 3;
        int graph1[][] = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int n2 = 4;
        int graph2[][] = {{1, 1, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        System.out.println(transitiveClosure(n1, graph1));
        System.out.println(transitiveClosure(n2, graph2));
    }       
}