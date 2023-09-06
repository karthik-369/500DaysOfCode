
//   Definition for singly-linked list.
type ListNode struct {
     Val int
      Next *ListNode
  }
 
 func splitListToParts(head *ListNode, k int) []*ListNode {
    arr := make([]*ListNode, k)
    temp := head
    count := 0
    for temp != nil {
        count++
        temp = temp.Next
    }
    temp = head
    rem := count % k
    c := count / k
    point := 0
    for temp != nil {
        arr[point] = temp
        point++
        l := c - 1
        if rem > 0 {
            l += 1
        }
        rem--
        for i:=0; i<l; i++ {
            temp = temp.Next
        }
        t := temp.Next
        temp.Next = nil
        temp = t
    }
    return arr
}