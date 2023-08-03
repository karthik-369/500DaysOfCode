package Day196;
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(temp.length()!=0){
                    sb.append(temp);
                    sb.append(' ');
                    temp = "";
                }
            }else{
                temp = s.charAt(i)+temp;
            }

        }
        System.out.println(temp);
        if(temp.length()!=0){
            sb.append(temp);
        }
        if(sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}