
class Solution
{
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        Map<Node, Node> map = new HashMap<>();
        map.put(root, null);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node current = root;
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                current = queue.peek();
                queue.poll();
                if(current.data == node){
                    flag= true;
                    break;
                }
                if(current.left!=null){
                    map.put(current.left, current);
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    map.put(current.right, current);
                    queue.offer(current.right);
                }
            }
            if(flag){
                break;
            }
        }
        while(k!=0){
            if(map.get(current)==null)
            {
                return -1;
            }
            current = map.get(current);
            k--;
        }
        return current.data;
    }
}