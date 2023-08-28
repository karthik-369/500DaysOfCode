package main

type Node struct {
	data int
	next *Node
}

func (n *Node) removeDuplicates(head *Node) *Node {
	temp := head
	for temp != nil && temp.next != nil {
		if temp.data == temp.next.data {
			temp.next = temp.next.next
		} else {
			temp = temp.next
		}
	}
	return head
}

