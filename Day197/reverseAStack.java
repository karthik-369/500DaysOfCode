package Day197;
import java.util.Stack;

//User function Template for Java

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
       if(s.isEmpty()|| s.size()==1){
           return;
       }
       int first = s.pop();
       reverse(s);
       push(s,first);
    }
    static void push(Stack<Integer> stack, int first){
        if(stack.isEmpty()){
            stack.push(first);
            return;
        }
        int f = stack.pop();
        push(stack, first);
        stack.push(f);
    }
}