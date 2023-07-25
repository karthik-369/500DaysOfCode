class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return answer;
        }
        String arr[] = {"abc","def","ghi","jkl","mno", "pqrs","tuv","wxyz"};
        letter(digits, "", arr, 0);
        return answer;
    }
    public void letter(String digits, String str, String arr[], int i){
        if(i==digits.length()){
            if(str.length()!=0){
                answer.add(str);
                return;
            }
        }
        int temp = digits.charAt(i) - '0';
        for(char c: arr[temp-2].toCharArray()){
            letter(digits, str+c, arr, i+1);
        }
    }
}