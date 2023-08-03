package Day196;

class Solution {


    List<String> answer = new ArrayList<>();

    public void find(String digits, String temp, String arr[], int i){
        if(i == digits.length()){
            if(temp.length()!=0){
                answer.add(temp);
                return;
            }
        }
        int t = digits.charAt(i) - '0';
        for(char c: arr[t-2].toCharArray()){
            find(digits, temp+c, arr, i+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return answer;
        }
        String nums[] = {"abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        find(digits, "", nums, 0);
        return answer;
    }


}