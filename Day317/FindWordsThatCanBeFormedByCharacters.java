class Solution {
    public boolean is(String word, int arr[]) {
        int temp[] = new int[26];
        for (int i=0; i<word.length(); i++) {
            int x = word.charAt(i) - 'a';
            temp[x]++;
            if (temp[x] > arr[x]) {
                return false;
            }
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        int arr[] = new int[26];
        for (int i=0; i<chars.length(); i++) {
            arr[chars.charAt(i)-'a']++;
        }
        int answer = 0;
        for (String v : words) {
            if (is(v, arr)) {
                answer += v.length();
            }
        }
        return answer;
    }
}
