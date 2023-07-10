//LeetCode 25
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode nextNode = null;
        ListNode prev = null;
        int count = 0;
        if(head == null){
            return null;
        }
        if(head.next == null || k==1){
            return head;
        }
        ListNode point = head;
        for(int i=0;i<k;i++){
            if(point == null){
                return head;
            }
            point = point.next;
        }
        while(current!=null && count<k){
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
            count++;
        }
        if(nextNode!=null){
            head.next = reverseKGroup(nextNode, k);
        }
        return prev;
    }
}