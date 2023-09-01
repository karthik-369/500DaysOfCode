
package main

import (
	"fmt"
	"github.com/golang-collections/collections/queue"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

func printCorner(node *Node) {
	q := queue.New()
	q.Enqueue(node)
	for !q.Empty() {
		size := q.Len()
		for i := 0; i < size; i++ {
			temp := q.Peek().(*Node)
			q.Dequeue()
			if i == 0 || i == size-1 {
				fmt.Printf("%d ", temp.data)
			}
			if temp.left != nil {
				q.Enqueue(temp.left)
			}
			if temp.right != nil {
				q.Enqueue(temp.right)
			}
		}
	}
}

