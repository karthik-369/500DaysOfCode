func copyRandomList(head *Node) *Node {
	if head == nil {
	return nil
}

curr := head
for curr != nil {
	new_node := &Node{Val: curr.Val, Next: curr.Next}
	curr.Next = new_node
	curr = new_node.Next
}

curr = head
for curr != nil {
	if curr.Random != nil {
		curr.Next.Random = curr.Random.Next
	}
	curr = curr.Next.Next
}

old_head := head
new_head := head.Next
curr_old := old_head
curr_new := new_head

for curr_old != nil {
	curr_old.Next = curr_old.Next.Next
	if curr_new.Next != nil {
		curr_new.Next = curr_new.Next.Next
	} else {
		curr_new.Next = nil
	}
	curr_old = curr_old.Next
	curr_new = curr_new.Next
}

return new_head
}

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

 func copyRandomList(head *Node) *Node {
    store := make(map[*Node]*Node)
    temp := head
    for temp != nil {
        store[temp] = &Node{Val: temp.Val}
        temp = temp.Next
    }
    temp = head
    for temp != nil {
        store[temp].Next = store[temp.Next]
        store[temp].Random = store[temp.Random]
        temp = temp.Next 
    }
    return store[head]
}