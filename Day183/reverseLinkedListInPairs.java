
class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        if(node == null){
            return null;
        }   
        if(node.next == null || k == 1){
            return node;
        }
        Node current = node;
        Node nxt = null;
        Node pre = null;
        int count = 0;
        while(current!=null && count<k){
            nxt = current.next;
            current.next = pre;
            pre = current;
            current = nxt;
            count++;
        }
        if(nxt!=null){
            Node temp = reverse(nxt, k);
            node.next = temp;
        }
        return pre;
    }
}
