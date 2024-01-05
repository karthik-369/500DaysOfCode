class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        int i = 0;
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                answer = Math.max(answer,i - map.get(c));
            } else {
                map.put(c, i);
            }
            i++;
        }
        return answer-1;
    }
}