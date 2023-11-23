package main

import (
	"fmt"
)

type pair struct {
	first  int
	second bool
}

type Node struct {
	data   int
	height int
	left   *Node
	right  *Node
}

func isBST(n *Node, lower, upper int) bool {
	if n == nil {
		return true
	}
	if n.data <= lower || n.data >= upper {
		return false
	}
	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper)
}

func isBalanced(n *Node) pair {
	if n == nil {
		return pair{0, true}
	}

	l := isBalanced(n.left)
	r := isBalanced(n.right)

	if abs(l.first-r.first) > 1 {
		return pair{0, false}
	}

	return pair{1 + max(l.first, r.first), l.second && r.second}
}

func isBalancedBST(root *Node) bool {
	if !isBST(root, -1<<63, 1<<63-1) {
		fmt.Print("BST violated, inorder traversal: ")
	} else if !isBalanced(root).second {
		fmt.Print("Unbalanced BST, inorder traversal: ")
	} else {
		return true
	}
	return false
}

func printInorder(n *Node) {
	if n == nil {
		return
	}
	printInorder(n.left)
	fmt.Print(n.data, " ")
	printInorder(n.right)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func rightRotate(y *Node) *Node {
	x := y.left
	t2 := x.right
	x.right = y
	y.left = t2
	y.height = 1 + max(height(y.left), height(y.right))
	x.height = 1 + max(height(x.left), height(x.right))
	return x
}

func leftRotate(x *Node) *Node {
	y := x.right
	t2 := y.left
	y.left = x
	x.right = t2
	x.height = 1 + max(height(x.left), height(x.right))
	y.height = 1 + max(height(y.left), height(y.right))
	return y
}

func insertToAVL(node *Node, data int) *Node {
	if node == nil {
		return &Node{data: data}
	}
	if data < node.data {
		node.left = insertToAVL(node.left, data)
	} else if data > node.data {
		node.right = insertToAVL(node.right, data)
	} else {
		return node
	}
	node.height = 1 + max(height(node.left), height(node.right))
	bal := getBalance(node)
	if bal > 1 && data < node.left.data {
		return rightRotate(node)
	}
	if bal < -1 && data > node.right.data {
		return leftRotate(node)
	}
	if bal > 1 && data > node.left.data {
		node.left = leftRotate(node.left)
		return rightRotate(node)
	}
	if bal < -1 && data < node.right.data {
		node.right = rightRotate(node.right)
		return leftRotate(node)
	}
	return node
}

func height(node *Node) int {
	if node == nil {
		return 0
	}
	return node.height
}

func getBalance(node *Node) int {
	if node == nil {
		return 0
	}
	return height(node.left) - height(node.right)
}

func main() {
	var ip [2000]int
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var n int
		fmt.Scan(&n)
		for i := 0; i < n; i++ {
			fmt.Scan(&ip[i])
		}

		var root *Node
		for i := 0; i < n; i++ {
			root = insertToAVL(root, ip[i])

			if !isBalancedBST(root) {
				break
			}
		}

		printInorder(root)
		fmt.Println()

		t--
	}
}
