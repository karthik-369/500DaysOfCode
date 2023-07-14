//Recurrsive solution suffers TLE
class Solution {
    public int max = 0;
    public void subsequence(int arr[], int index, List<Integer> list, int diff){
        if(index == arr.length){
            if(list.size()>0){
                // System.out.println(lis
                    boolean flag = true;
                    for(int i=1;i<list.size();i++){
                        if(diff!=list.get(i)-list.get(i-1)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        max = Math.max(max, list.size());
                    }
            }
        }else{
            subsequence(arr, index+1, list,diff);
            list.add(arr[index]);
            subsequence(arr, index+1, list, diff);
            list.remove(list.size()-1);
        }
        return;
    }
    public int longestSubsequence(int[] arr, int difference) {
        if(difference == 1){
            if(arr.length==1)
            return 1;
        }
        if(arr.length==1){
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        subsequence(arr, 0, list, difference);
        return max;   
    }
}

//DP 
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int answer = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i-difference, 0)+1);
            answer = Math.max(answer, map.get(i));
        }
        return answer;
    }
}