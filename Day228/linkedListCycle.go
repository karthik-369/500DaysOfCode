/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func hasCycle(head *ListNode) bool {
    if head == nil || head.Next == nil {
        return false
    }
    first := head
    second := head
    for first!=nil && first.Next != nil {
        first = first.Next.Next
        second = second.Next
        if first == second {
            return true
        }
    }
    return false
}