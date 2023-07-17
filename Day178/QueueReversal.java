class GfG{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
       Stack<Integer>stack = new Stack<>();
       while(!q.isEmpty()){
           stack.add(q.remove());
       }
       while(!stack.isEmpty()){
           q.offer(stack.pop());
       }
       return q;
    }
}