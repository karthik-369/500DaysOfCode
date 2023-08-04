package Day197;
import java.util.List;
import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Set;
// import java.util.Arrays;

public class WordBreadk {

    public static void main(String[] args){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");        
        System.out.println(wordBreak(s, wordDict));
    }
     public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0){
            return false;
        }
        boolean arr[] = new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                String temp = s.substring(j, i+1);
                if(wordDict.contains(temp) && (j==0||arr[j-1])){
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[s.length()-1];
    }
//     public static boolean wordBreak(String s, List<String> wordDict) {
//         // Set<String> set = new HashSet<>(wordDict);
//         // for(int i=0;i<wordDict.size();i++){
//         //     set.add(wordDict.get(i));
//         // }
        

//         return search(0, s, wordDict);

//     }
//     public static boolean search(int i, String s, List<String> dict){
//         if(i==s.length()){
//             return true;
//         }
//         String temp = "";
//         
//         for(int j=i;j<s.length();j++){
//             temp += s.charAt(j);
//             if(dict.contains(temp)){
//                 if(search(j+1, s, dict)){
//                     
//                     return true;
//                 }
//             }
//         }
//         
//         return false;
//     }
}


