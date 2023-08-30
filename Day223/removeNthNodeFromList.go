package main

type Node struct {
	data int
	next *Node
}

func deleteNode(head *Node, x int) *Node {
	temp := head
	if temp.next.next == nil && x == 1 {
		return head.next
	}
	if temp.next.next != nil && x == 1 {
		return head.next
	}
	x--
	for x != 1 {
		temp = temp.next
		x--
	}
	temp.next = temp.next.next
	return head
}
