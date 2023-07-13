class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> path = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            path.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[numCourses];
        int[] r = new int[numCourses];
        for(int []temp: prerequisites){
            path.get(temp[1]).add(temp[0]);
        } 
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && safe(path, i, r, visited)){
                return false;
            }
        }
        return true;
    }
    public boolean safe(List<List<Integer>> path, int source, int[] r, boolean[] visited){
        visited[source] = true;
        r[source] = 1;
        for(int i:path.get(source)){
            if(!visited[i]&&safe(path, i, r, visited)){
                return true;
            }else if(r[i]==1){
                return true;
            }
        }
        r[source] = 0;
        return false;
    }
}