package main

import (
	"fmt"
	"sort"
	"strings"
)

// Node struct represents a node in the BST
type Node struct {
	data  int
	left  *Node
	right *Node
}

// countPairs function returns the count of pairs from two BSTs whose sum is equal to x
func countPairs(root1, root2 *Node, x int) int {
	list1 := inorder(root1)
	list2 := inorder(root2)

	sort.Ints(list1)
	sort.Ints(list2)

	answer := 0
	i, j := 0, len(list2)-1

	for i < len(list1) && j >= 0 {
		if list1[i]+list2[j] == x {
			answer++
		}
		if list1[i]+list2[j] < x {
			i++
		} else {
			j--
		}
	}

	return answer
}

// inorder function returns the inorder traversal of a BST as a list
func inorder(root *Node) []int {
	var list []int
	if root != nil {
		list = append(list, inorder(root.left)...)
		list = append(list, root.data)
		list = append(list, inorder(root.right)...)
	}
	return list
}

func buildTree(input string) *Node {
	if len(input) == 0 || input[0] == 'N' {
		return nil
	}

	nodes := strings.Split(input, " ")
	root := &Node{}
	queue := []*Node{root}
	i := 1

	for len(queue) > 0 && i < len(nodes) {
		currNode := queue[0]
		queue = queue[1:]

		currVal := nodes[i]
		i++

		if currVal != "N" {
			currNode.data = parseInt(currVal)
			currNode.left = &Node{}
			currNode.right = &Node{}
			queue = append(queue, currNode.left, currNode.right)
		}
	}

	return root
}

func parseInt(s string) int {
	var result int
	fmt.Sscanf(s, "%d", &result)
	return result
}

func main() {
	var t int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var tree1, tree2 string
		fmt.Scan(&tree1, &tree2)

		root1 := buildTree(tree1)
		root2 := buildTree(tree2)

		var x int
		fmt.Scan(&x)

		result := countPairs(root1, root2, x)
		fmt.Println(result)
	}
}
