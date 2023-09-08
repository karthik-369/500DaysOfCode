package main

import (
	"fmt"
	"sort"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

func binaryTreeToBST(root *Node) *Node {
	list := make([]int, 0)
	traverse(root, &list)
	sort.Ints(list)
	i := 0 // Reset i before starting the inorder traversal
	return inorder(root, list, &i)
}

func traverse(root *Node, list *[]int) {
	if root == nil {
		return
	}
	*list = append(*list, root.data)
	traverse(root.left, list)
	traverse(root.right, list)
}

func inorder(root *Node, list []int, i *int) *Node {
	if root == nil {
		return nil
	}
	root.left = inorder(root.left, list, i)
	root.data = list[*i]
	*i++
	root.right = inorder(root.right, list, i)
	return root
}

func main() {
	// Create and manipulate the binary tree here
}
