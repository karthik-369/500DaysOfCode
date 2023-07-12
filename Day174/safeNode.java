class Solution {
    public boolean safe(int[][] graph, int node, int visit[]){
        if(visit[node]!=0){
            return visit[node]==2;
        }
        visit[node] = 1;
        for(int i:graph[node]){
            if(!safe(graph, i, visit)){
                return false;
            }
        }
        visit[node] = 2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> answer = new ArrayList<>();
        int len = graph.length;
        int[] visit = new int[len];
        for(int i=0;i<len;i++){
            if(safe(graph, i, visit)){
                answer.add(i);
            }
        }
        return answer;
    }
}
