
class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        int arr[] = new int[26];
        StringBuilder answer = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(char c: A.toCharArray()){
            arr[c-'a']++;
            queue.offer(c);
            while(!queue.isEmpty()&&arr[queue.peek()-'a']>1){
                queue.remove();
            }
            if(!queue.isEmpty()){
                answer.append(queue.peek());
            }else{
                answer.append('#');
            }
        }
        return answer.toString();
    }
}