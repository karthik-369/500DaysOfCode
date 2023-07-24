
class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(i==size-1){
                    list.add(temp.data);
                }
                if(temp.left!=null){
                    queue.offer(temp.left);
                }if(temp.right!=null){
                    queue.offer(temp.right);
                }
                
            }
        }
        return list;
    }
}

