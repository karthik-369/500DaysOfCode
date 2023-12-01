package main

import (
	"fmt"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

type BinarySearchTree struct {
	root *Node
}

func (bst *BinarySearchTree) insert(key int) {
	bst.root = bst.insertRec(bst.root, key)
}

func (bst *BinarySearchTree) insertRec(root *Node, key int) *Node {
	if root == nil {
		root = &Node{data: key}
		return root
	}
	if key < root.data {
		root.left = bst.insertRec(root.left, key)
	} else if key > root.data {
		root.right = bst.insertRec(root.right, key)
	}
	return root
}

func (bst *BinarySearchTree) inorder() {
	inorderRec(bst.root)
}

func inorderRec(root *Node) {
	if root != nil {
		inorderRec(root.left)
		fmt.Print(root.data)
		inorderRec(root.right)
	}
}

type Solution struct{}

func (sol *Solution) find(root *Node, min, max int) bool {
	if root == nil {
		return false
	}
	if min == max {
		return true
	}
	return sol.find(root.left, min, root.data-1) || sol.find(root.right, root.data+1, max)
}

func (sol *Solution) isDeadEnd(root *Node) bool {
	return sol.find(root, 1, int(^uint(0)>>1))
}

func main() {
	var t, n, b int
	fmt.Scan(&t)

	for tc := 0; tc < t; tc++ {
		fmt.Scan(&n)
		obj1 := BinarySearchTree{}
		for i := 0; i < n; i++ {
			fmt.Scan(&b)
			obj1.insert(b)
		}
		obj := Solution{}
		k := obj.isDeadEnd(obj1.root)
		if k == true {
			fmt.Println("1")
		} else {
			fmt.Println("0")
		}
	}
}
