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

func buildTree(str []string) *Node {
	index := 0
	val, _ := strconv.Atoi(str[index])
	index++
	root := &Node{data: val}
	queue := []*Node{root}

	for len(queue) > 0 && index < len(str) {
		currNode := queue[0]
		queue = queue[1:]

		currVal := str[index]
		index++

		if currVal != "N" {
			val, _ := strconv.Atoi(currVal)
			currNode.left = &Node{data: val}
			queue = append(queue, currNode.left)
		}

		if index >= len(str) {
			break
		}

		currVal = str[index]
		index++

		if currVal != "N" {
			val, _ := strconv.Atoi(currVal)
			currNode.right = &Node{data: val}
			queue = append(queue, currNode.right)
		}
	}

	return root
}

func height(node *Node) int {
	if node == nil {
		return 0
	}
	leftHeight := height(node.left)
	rightHeight := height(node.right)
	return 1 + max(leftHeight, rightHeight)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t, _ := strconv.Atoi(scanner.Text())

	for t > 0 {
		scanner.Scan()
		s := scanner.Text()
		str := strings.Fields(s)
		root := buildTree(str)
		fmt.Println(height(root))
		t--
	}
}
