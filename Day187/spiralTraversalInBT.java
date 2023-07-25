
class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code 
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer>temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                temp.add(curr.data);
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
                
            }
            if(flag){
                answer.addAll(temp);
                flag = false;
            }else{
                Collections.reverse(temp);
                flag = true;
                answer.addAll(temp);
            }
        }
        return answer;
    }
}