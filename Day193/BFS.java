
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        queue.offer(0);
        answer.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            int temp = queue.poll();
            for(int i=0;i<adj.get(temp).size();i++){
                int n = adj.get(temp).get(i);
                if(!visited[n]){
                    answer.add(n);
                    queue.offer(n);
                    visited[n] = true;
                }
            }
        }
        return answer;
    }
}