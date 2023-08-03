package Day196;
import java.util.Arrays;
import java.util.Stack;
public class ShortestPathDAG{
    public static void main(String[] args){
        int arr[][] = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int N = 6;
        int M = 7;
        int answer[] = shortestPath(N, M, arr);
        System.out.println(Arrays.toString(answer));
    }
    public static void sort(int arr[][], boolean[] visited, int source, Stack<Integer> stack){
        visited[source] = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==source){
                if(!visited[arr[i][1]]){
                    sort(arr, visited, arr[i][1], stack);
                }
            }
        }
        stack.push(source);
    }
    public static int[] shortestPath(int N, int M, int[][] arr){
        int distance[] = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[N];

        for(int i=0;i<N;i++){
            if(!visited[i]){
                sort(arr, visited, i, stack);
            }
        }
        System.out.println(stack);
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(int i=0;i<M;i++){
                if(arr[i][0]==temp && distance[temp]!=Integer.MAX_VALUE){
                    if(distance[arr[i][1]]>(distance[temp]+arr[i][2])){
                        distance[arr[i][1]] = distance[temp]+arr[i][2];
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i]= -1;
            }
        }
        return distance;
    }
}