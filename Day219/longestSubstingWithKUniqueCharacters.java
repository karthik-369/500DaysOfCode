package Day219;

import java.util.Map;
import java.util.HashMap;

public class longestSubstingWithKUniqueCharacters {
    
    public static int longestSubstring(String str, int k) {
        if (k>str.length()) {
            return -1;
        }
        if (str.length() == 0 || k == 0) {
            return 0;
        }
        int startIndex = 0, endIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        while (endIndex < str.length()) {
            if (!map.containsKey(str.charAt(endIndex))) {
                k--;
            }
            map.put(str.charAt(endIndex), endIndex);
            while (k < 0) {
                if (map.get(str.charAt(startIndex)) == startIndex) {
                    k++;
                    map.remove(str.charAt(startIndex));
                }
                startIndex++;
            }
            answer = Math.max(answer, endIndex - startIndex + 1);
            endIndex++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "aabacbghjyelllloooobebe";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }
}