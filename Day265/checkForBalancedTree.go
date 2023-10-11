package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

func buildTree(str string) *Node {
	if str == "" || str == "N" {
		return nil
	}
	ip := strings.Split(str, " ")
	rootData, _ := strconv.Atoi(ip[0])
	root := &Node{data: rootData}
	queue := []*Node{root}
	i := 1
	for i < len(ip) && len(queue) > 0 {
		currNode := queue[0]
		queue = queue[1:]
		currVal := ip[i]
		if currVal != "N" {
			leftData, _ := strconv.Atoi(currVal)
			currNode.left = &Node{data: leftData}
			queue = append(queue, currNode.left)
		}
		i++
		if i >= len(ip) {
			break
		}
		currVal = ip[i]
		if currVal != "N" {
			rightData, _ := strconv.Atoi(currVal)
			currNode.right = &Node{data: rightData}
			queue = append(queue, currNode.right)
		}
		i++
	}
	return root
}

func isBalanced(root *Node) bool {
	if root == nil {
		return true
	}
	height := func(node *Node) int {
		if node == nil {
			return 0
		}
		leftHeight := height(node.left)
		rightHeight := height(node.right)
		if leftHeight == -1 || rightHeight == -1 || abs(leftHeight-rightHeight) > 1 {
			return -1
		}
		return max(leftHeight, rightHeight) + 1
	}

	return height(root) != -1
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tStr, _ := reader.ReadString('\n')
	t, _ := strconv.Atoi(strings.TrimSpace(tStr))
	for t > 0 {
		s, _ := reader.ReadString('\n')
		root := buildTree(strings.TrimSpace(s))
		if isBalanced(root) {
			fmt.Println(1)
		} else {
			fmt.Println(0)
		}
		t--
	}
}
