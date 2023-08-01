class Solution {
    
    public void find(int n, int k, int index, List<List<Integer>> answer, List<Integer> temp){
        if(temp.size()==k){
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<=n;i++){
            temp.add(i);
            find(n, k, i+1, answer, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n ,int k){
        List<List<Integer>> answer = new ArrayList<>();
        find(n, k, 1, answer, new ArrayList<>());
        return answer;
    }
}