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
	if len(str) == 0 || str == "N" {
		return nil
	}

	s := strings.Split(str, " ")

	rootData, _ := strconv.Atoi(s[0])
	root := &Node{data: rootData}
	queue := []*Node{root}

	i := 1
	for len(queue) > 0 && i < len(s) {
		currNode := queue[0]
		queue = queue[1:]

		currVal := s[i]
		if currVal != "N" {
			leftData, _ := strconv.Atoi(currVal)
			currNode.left = &Node{data: leftData}
			queue = append(queue, currNode.left)
		}

		i++
		if i >= len(s) {
			break
		}

		currVal = s[i]
		if currVal != "N" {
			rightData, _ := strconv.Atoi(currVal)
			currNode.right = &Node{data: rightData}
			queue = append(queue, currNode.right)
		}

		i++
	}

	return root
}

func inorder(root *Node) {
	if root == nil {
		return
	}

	inorder(root.left)
	fmt.Print(root.data, " ")
	inorder(root.right)
}

type Solution struct{}

func (s *Solution) insert(root *Node, key int) *Node {
	if root == nil {
		return &Node{data: key}
	}

	if root.data > key {
		root.left = s.insert(root.left, key)
	} else if root.data < key {
		root.right = s.insert(root.right, key)
	}

	return root
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tStr, _ := reader.ReadString('\n')
	t, _ := strconv.Atoi(strings.TrimSpace(tStr))

	for t > 0 {
		s, _ := reader.ReadString('\n')
		s = strings.TrimSpace(s)
		root := buildTree(s)

		keyStr, _ := reader.ReadString('\n')
		key, _ := strconv.Atoi(strings.TrimSpace(keyStr))

		var T Solution
		root = T.insert(root, key)
		inorder(root)
		fmt.Println()

		t--
	}
}
