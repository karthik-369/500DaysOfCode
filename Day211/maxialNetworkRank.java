package Day211;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class maxialNetworkRank {
    public static int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> con = new HashMap<>();
        for (int i=0; i<n; i++) {
            con.put(i, new HashSet<>());
        }
        for (int i=0; i<roads.length; i++) {
            con.get(roads[i][0]).add(roads[i][1]);
            con.get(roads[i][1]).add(roads[i][0]);
        }
        int answer = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int temp = con.get(i).size() + con.get(j).size();
                if (con.get(i).contains(j)) {
                    temp--;
                }
                answer = Math.max(answer, temp);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int graph[][] = {{0,1},{0,3},{1,2},{1,3}};
        int n = 4;
        System.out.println(maximalNetworkRank(n, graph));
    }
}
