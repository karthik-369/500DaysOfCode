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
        head = prev;
        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode answer = null;
        ListNode tail = null;
        return reverse(add(l1, l2, 0));
    }
    public ListNode add(ListNode l1, ListNode l2, int carry){
        if(l1 ==null && l2 ==null && carry ==0){
            return null;
        }else{
            int sum = carry;
            if(l1!=null){
                sum+=l1.val;
            }
            if(l2!=null){
                sum+=l2.val;
            }
            ListNode answer = new ListNode(sum%10);
            answer.next = add(l1==null?null: l1.next, l2==null?null:l2.next, sum/10);
            return answer;
        }
    }
}