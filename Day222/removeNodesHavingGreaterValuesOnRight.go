package main

type Node struct {
	data int
	next *Node
}

func reverse(head *Node) *Node {
	var curr, prev *Node = head, nil
	for curr != nil {
		temp := curr.next
		curr.next = prev
		prev = curr
		curr = temp
	}
	return prev
}

func compute(head *Node) *Node {
	temp := reverse(head)
	curr, prev := temp, temp
	for curr.next != nil {
		if curr.next.data >= prev.data {
			prev.next = curr.next
			prev = prev.next
		}
		curr = curr.next
	}
	prev.next = nil
	return reverse(temp)
}


