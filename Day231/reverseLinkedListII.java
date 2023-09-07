package Day231;
//   Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode nextNode = head;
        ListNode prev = null;
        while(current!=null){
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode start = null;
        ListNode end = null;
        int i = 1;
        while(current!=null){
            if(i>right){
                break;
            }
            if(i<left){
                start = current;
            }
            if(i==right){
                end = current;
            }
            current = current.next;
            i++;
        }

        end.next = null;
        if(left == 1){
            end = head;
            head = reverse(head);
        }else{
            end = start.next;
            start.next = reverse(start.next);
        }
        end.next = current;
        return head;

    }
}