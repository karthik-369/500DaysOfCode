package Day247;

import java.util.Arrays;

class Trie {
    Trie[] next = new  Trie[26];
    boolean end = false;
    int branch = 0;
    void addWord(String word, int pos, int branch){
        if (pos == word.length()) {
            end = true;
            this.branch = branch;
            return;
        }
        char temp = word.charAt(pos);
        if (next[temp - 'a'] == null) {
            next[temp - 'a'] = new Trie();
        }
        next[temp-'a'].addWord(word, pos+1, branch);
    }
    public int find(String word, int pos, boolean flag) {
        if (pos == word.length() && flag) {
            return branch;
        } 
        int max = 0;
        for (int i=0; i<26 && !flag; i++) {
            if (next[i] == null) {
                continue;
            }
            max =Math.max(max, next[i].find(word, pos, true));
        }
        if (pos == word.length()) {
            return max;
        }
        char temp = word.charAt(pos);
        if (next[temp-'a'] != null) {
            max =Math.max(max, next[temp-'a'].find(word, pos+1, flag));
        }
        return max;
    }
    // @Override
    // public String toString() {
    //     return 
    // }
}

public class longestStringChain {

    public static int longestStrChain(String[] words) {
        int answer = 0;
        Arrays.sort(words, (a,b)-> b.length() - a.length());
        Trie trie = new Trie();
        for (int i=0; i<words.length; i++) {
            int current = 1 + trie.find(words[i], 0, false);
            trie.addWord(words[i], 0, current);
            answer = Math.max(answer, current);

        }
        return answer;
    }
    public static void main(String[] args) {
        String arr[] = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(arr));
    }
}