/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func reverseBetween(head *ListNode, left int, right int) *ListNode {
    temp := &ListNode{Next: head}
    first := temp
    for i:=1; i<left; i++ {
        first = first.Next
    }
    prev, curr, next := first, first.Next, first.Next.Next
    for i:=left; i<right; i++ {
        prev, curr, next = curr, next, next.Next
        curr.Next = prev
    }
    first.Next.Next = next
    first.Next = curr
    return temp.Next
}