class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        if (routes.length == 1) {
            return -1;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int answer = 0;
        for (int i=0; i<routes.length; i++) {
            for (int j=0; j<routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<>());
                }
                map.get(routes[i][j]).add(i);
            }
        }
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i=0; i<size; i++) {
                int temp = queue.poll();
                List<Integer> bus = map.get(temp);
                for (int v: bus) {
                    if (visited.contains(v)) {
                        continue;
                    }
                    visited.add(v);
                    for (int j=0; j<routes[v].length; j++) {
                        if (routes[v][j] == target) {
                            return answer;
                        }
                        queue.offer(routes[v][j]);
                    }
                }
            }
        }
        return -1;
    }
}