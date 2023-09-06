import java.util.List;
import java.util.ArrayList;
public class motherVertex {
    public static List<Integer> convert(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
    public static void main(String[]args){
        int v = 5;
        int arr[][] = {{1,0},{0,2},{2,1},{2,3},{3,4}};
        List<List<Integer>>list = new  ArrayList<>();
        for (int i=0; i<arr.length; i++) { 
            List<Integer> temp = convert(arr[i]);
            list.add(temp);
        }
        System.out.println(list);
        System.out.println(findMotherVertex(v, list));
    }

    public static int findMotherVertex(int V, List<List<Integer>> adj) {

        boolean visited[] = new boolean[V];
        int mother = 0;
        for (int i=0; i<V; i++) {
            if (!visited[i]){
                mother = i;
                dfs(i, visited, adj);
            }
        }
        visited = new boolean[V];
        dfs(mother, visited, adj);
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return mother;
    }
    public static void dfs(int i, boolean[] visited, List<List<Integer>> adj) {
        
        visited[i] = true;
        for (int n: adj.get(i)) {
            if (!visited[n]) {
                dfs(n, visited, adj);
            }
        }
        return;
    }
}
