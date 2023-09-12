class minimumDeletionToMakeCharactersUnique {
    public int minDeletions(String s) {
        int arr[] = new int[26];
        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<26; i++) {
            int temp = arr[i];
            while (temp > 0) {
                if (!set.contains(temp)) {
                    set.add(temp);
                    break;
                }
                temp--;
                answer++;
            }
        }
        return answer;
    }
}