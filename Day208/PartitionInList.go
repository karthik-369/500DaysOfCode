package main


//   Definition for singly-linked list.
  type ListNode struct {
      Val int
	  Next *ListNode
   }

 func partition(head *ListNode, x int) *ListNode {
    list1 := &ListNode{}
    list2 := &ListNode{}
    head1 := list1
    head2 := list2
    for head != nil {
        if head.Val < x {
            head1.Next = head;
            head1 = head1.Next;
        } else {
            head2.Next = head;
            head2 = head2.Next;
        }
        head = head.Next;
    }
    head2.Next = nil;
    head1.Next = list2.Next;
    return list1.Next;
}
