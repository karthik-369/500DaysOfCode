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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode arr[] = new ListNode[k];
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        int rem = count % k;
        int c = count / k;
        int point  = 0;
        
        while (temp != null) {
            arr[point++] = temp;
            int len = c - 1 + ((rem-- > 0) ? 1: 0);
            for (int i=0; i<len; i++) {
                temp = temp.next;
            }
            ListNode t = temp.next;
            temp.next = null;
            temp = t;
        }
        return arr;
    }
}