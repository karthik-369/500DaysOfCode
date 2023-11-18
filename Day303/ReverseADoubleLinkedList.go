package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// Node represents a node in a doubly linked list
type Node struct {
	data int
	next *Node
	prev *Node
}

func reverseDLL(head *Node) *Node {
	var curr, temp *Node

	curr = head
	for curr != nil {
		temp = curr.prev
		curr.prev = curr.next
		curr.next = temp
		curr = curr.prev
	}

	// Update head to point to the last node
	if temp != nil {
		head = temp.prev
	}

	return head
}

func displayList(head *Node) {
	// Head to Tail
	for head.next != nil {
		fmt.Print(head.data, " ")
		head = head.next
	}
	fmt.Print(head.data)
}

func verify(head *Node) bool {
	var fl, bl int

	temp := head

	// Forward traversal
	for temp.next != nil {
		temp = temp.next
		fl++
	}

	temp = head

	// Backward traversal
	for temp.prev != nil {
		temp = temp.prev
		bl++
	}

	return fl == bl
}

func main() {
	// Input reading
	scanner := bufio.NewScanner(os.Stdin)

	t, _ := strconv.Atoi(readLine(scanner))
	for i := 0; i < t; i++ {
		n, _ := strconv.Atoi(readLine(scanner))
		str := strings.Fields(readLine(scanner))
		var head, tail *Node

		for j := 0; j < n; j++ {
			data, _ := strconv.Atoi(str[j])
			if head == nil {
				head = &Node{data: data}
				tail = head
			} else {
				tail.next = &Node{data: data, prev: tail}
				tail = tail.next
			}
		}

		// Reverse doubly linked list
		head = reverseDLL(head)

		// Display reversed list and verify
		if verify(head) {
			displayList(head)
		} else {
			fmt.Print("Your pointers are not correctly connected")
		}
		fmt.Println()
	}
}

func readLine(scanner *bufio.Scanner) string {
	scanner.Scan()
	return scanner.Text()
}
