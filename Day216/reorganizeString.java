package Day216;
import java.util.PriorityQueue;

class Pair {
    int a, b;
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int arr[] = new int[26];
        int len = s.length();
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a,b)->b.a - a.a);
        for (int i=0; i<len; i++) {
            int temp = s.charAt(i) - 'a';
            arr[temp]++;
            if(arr[temp]>(len+1)/2){
                return "";
            }
        }
        for (int i=0; i<26; i++) {
            if (arr[i] !=0) {
                priorityQueue.offer(new Pair(arr[i], i));
            }
        }
        
        StringBuilder answer = new StringBuilder();
        while (priorityQueue.size() >= 2) {
            // System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            //  for(Pair temp: priorityQueue) {
            //     System.out.println((char)(temp.b + 97) + " "+ temp.a);
            // }
            Pair temp1 = priorityQueue.poll();
            // System.out.println("first");
            //  for(Pair temp: priorityQueue) {
            //     System.out.println((char)(temp.b + 97) + " "+ temp.a);
            // }

            Pair temp2 = priorityQueue.poll();
            // System.out.println("second");
            //  for(Pair temp: priorityQueue) {
            //     System.out.println((char)(temp.b + 97) + " "+ temp.a);
            // }
            answer.append((char)(temp1.b+97));
            answer.append((char)(temp2.b+97));
            if (temp1.a > 1) {
                priorityQueue.offer(new Pair(temp1.a - 1, temp1.b));
            }
            if(temp2.a > 1) {
                priorityQueue.offer(new Pair(temp2.a - 1, temp2.b));
            }
        }
        if (!priorityQueue.isEmpty()) {
            answer.append((char)(priorityQueue.poll().b+97));
        }
        return answer.toString();
    }
}