package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// Node represents a node in the binary tree
type Node struct {
	data  int
	left  *Node
	right *Node
}

// Tree contains methods to build and print a binary tree
type Tree struct{}

// buildTree constructs a binary tree from a given string
func (t *Tree) buildTree(str string) *Node {
	if len(str) == 0 || str[0] == 'N' {
		return nil
	}

	ip := strings.Split(str, " ")
	root := &Node{}
	root.data, _ = strconv.Atoi(ip[0])
	queue := []*Node{root}
	i := 1

	for len(queue) > 0 && i < len(ip) {
		currNode := queue[0]
		queue = queue[1:]

		currVal := ip[i]

		if currVal != "N" {
			currNode.left = &Node{}
			currNode.left.data, _ = strconv.Atoi(currVal)
			queue = append(queue, currNode.left)
		}

		i++
		if i >= len(ip) {
			break
		}

		currVal = ip[i]

		if currVal != "N" {
			currNode.right = &Node{}
			currNode.right.data, _ = strconv.Atoi(currVal)
			queue = append(queue, currNode.right)
		}
		i++
	}

	return root
}

// printInorder prints the inorder traversal of the binary tree
func (t *Tree) printInorder(root *Node) {
	if root == nil {
		return
	}

	t.printInorder(root.left)
	fmt.Print(root.data, " ")
	t.printInorder(root.right)
}

// GfG contains the logic to check whether a binary tree is symmetric
type GfG struct{}

// isSymmetric checks whether a binary tree is symmetric
func (g *GfG) isSymmetric(root *Node) bool {
	return g.funcSymmetric(root, root)
}

// funcSymmetric is a recursive helper method to check symmetry
func (g *GfG) funcSymmetric(root1, root2 *Node) bool {
	if root1 == nil && root2 == nil {
		return true
	}
	if root1 == nil || root2 == nil {
		return false
	}
	if root1.data != root2.data {
		return false
	}
	return g.funcSymmetric(root1.left, root2.right) && g.funcSymmetric(root1.right, root2.left)
}

func main() {
	reader := bufio.NewReader(os.Stdin)

	t, _ := strconv.Atoi(readLine(reader))

	for t > 0 {
		s := readLine(reader)
		tree := &Tree{}
		root := tree.buildTree(s)

		g := &GfG{}
		if g.isSymmetric(root) {
			fmt.Println("True")
		} else {
			fmt.Println("False")
		}

		t--
	}
}

// readLine reads a line from the input
func readLine(reader *bufio.Reader) string {
	str, _ := reader.ReadString('\n')
	return strings.TrimSpace(str)
}
