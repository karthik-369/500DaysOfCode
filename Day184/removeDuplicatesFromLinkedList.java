
class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
       Node current = head;
       Node prev = null;
       if(head == null){
           return head;
       }
       Set<Integer> set = new HashSet<>();
       while(current!=null){
           int d = current.data;
           if(set.contains(d)){
               prev.next = current.next;
           }else{
               set.add(d);
               prev = current;
           }
           current = current.next;
       }
       return head;
    }
}