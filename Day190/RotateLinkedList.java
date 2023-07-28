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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        k%=len;
        // System.out.println(k);
        while(k>0){
            // System.out.println("ididid");
            head = rotate(head);
            k--;
        }
        return head;
    }
    public ListNode rotate(ListNode head){
        ListNode temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
