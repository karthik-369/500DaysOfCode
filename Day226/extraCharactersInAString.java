public int minExtraChar(String s, String[] dictionary) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = dfs(s, dictionary, map);
        return answer;
    }
    public int dfs(String str, String[] dict, Map<Integer, Integer> map) {
        if (str.length() == 0) {
            return 0;
        }
        if (map. containsKey(str.length())) {
            return map.get(str.length());
        }
        int min = str.length();
        for (String words: dict) {
            if (str.equals(words)) {
                min = 0;
                map.put(str.length(), min);
                return min;
            } else if (str.startsWith(words)) {
                int answer = dfs(str.substring(words.length()), dict, map);
                min = Math.min(min, answer);
            }
        }
        int answer = 1 + dfs(str.substring(1), dict, map);
        min = Math.min(min, answer);
        map.put(str.length(), min);
        return min;
    }