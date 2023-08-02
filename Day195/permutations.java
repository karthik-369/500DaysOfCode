package Day195;
import java.util.ArrayList;
import java.util.List;

class permutation{
    public static void main(String[] args){
        int arr[] = {1,2,3};
        List<List<Integer>> answer = perm(arr);
        for(List<Integer> temp: answer){
            System.out.println(temp);
        }
    }
    public static List<List<Integer>> perm(int[] arr){
        List<List<Integer>> answer = new ArrayList<>();
        boolean visited[] = new boolean[arr.length];
        find(arr, answer, visited, new ArrayList<>());
        return answer;
    }
    public static void find(int arr[], List<List<Integer>> answer, boolean[] visited, List<Integer> temp){
        if(temp.size() == arr.length){
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(arr[i]);
                find(arr, answer, visited, temp);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}