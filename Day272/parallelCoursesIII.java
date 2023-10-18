package Day272;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class parallelCoursesIII {

    public static int minimumTime(int n, int relations[][], int time[]) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> graph = new HashMap();
        int id[] = new int[n+1];
        int temp[] = new int[n+1];
        System.arraycopy(time, 0, temp, 1, n);
        for (int[] i: relations) {
           graph.computeIfAbsent(i[0], k-> new ArrayList<>()).add(i[1]);
           id[i[1]]++;
        }
        for (int i=1; i<= n; i++) {
            if (id[i] == 0 ) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            if (graph.containsKey(t)) {
                for (int nb : graph.get(t)) {
                    temp[nb] = Math.max(temp[nb], temp[t] + time[nb-1]);
                    id[nb]--;
                    if (id[nb] == 0) {
                        queue.offer(nb);
                    }
                }
            }
        }
        for (int i=0; i<=n; i++) {
            answer = Math.max(answer, temp[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int relations1[][] = {{1,3}, {2,3}};
        int time1[] = {3,2,5};
        int n2 = 5;
        int relations2[][] = {{1,5}, {2,5}, {3,5}, {3,4}, {4,5}};
        int time2[] = {1,2,3,4,5};
        System.out.println(minimumTime(n1, relations1, time1));
        System.out.println(minimumTime(n2, relations2, time2));

    }
}