class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        ArrayList<Integer> answer = new ArrayList<>();
        visited[0] =true;
        dfs(0, adj, answer, visited);
        return answer;
    }
    public void dfs(int source,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> answer, boolean[] visited){
        visited[source] = true;
        answer.add(source);
        for(int i=0;i<adj.get(source).size();i++){
            int n = adj.get(source).get(i);
            if(!visited[n]){
                dfs(n, adj, answer, visited);
            }
        }
    }
}
