
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top = -1;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
        top = x;
    }
    
    public int pop() {
        int to = -1;
        if (!empty()) {
            while(queue1.size()!=1) {
                queue2.offer(queue1.poll());
            }
             to = queue1.poll();
            while(!queue2.isEmpty()) {
               top = queue2.poll();
                queue1.offer(top);
            }
        }   
        return to;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue1.size()==0;
    }
}