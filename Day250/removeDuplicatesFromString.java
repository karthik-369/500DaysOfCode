package Day250;

import java.util.Stack;

public class removeDuplicatesFromString {

    public static String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();

        boolean visited[] = new boolean[26];
        int arr[] = new int[26];
        
        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if (visited[temp - 'a']) {
                arr[temp - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > temp && arr[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(temp);
            visited[temp - 'a'] = true;
            arr[temp - 'a']--;
        }

        // System.out.println(stack);

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "bcabc";
        String str2 = "cbacdcbc";
        String str3 = "cdadabcc";
        System.out.println(removeDuplicateLetters(str));
        System.out.println(removeDuplicateLetters(str2));
        System.out.println(removeDuplicateLetters(str3));
    }
}