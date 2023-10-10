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
	s := strings.Split(str, " ")
	rootData, _ := strconv.Atoi(s[0])
	root := &Node{data: rootData}
	queue := []*Node{root}
	i := 1
	for i < len(s) && len(queue) > 0 {
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

func KDistanceNodes(root *Node, target, k int) []int {
	var answer []int
	var queue []*Node
	var check map[int]bool = make(map[int]bool)

	var dfs func(node *Node)
	dfs = func(node *Node) {
		if node == nil {
			return
		}
		if node.data == target {
			queue = append(queue, node)
			return
		}
		dfs(node.left)
		dfs(node.right)
	}

	dfs(root)

	for k > 0 && len(queue) > 0 {
		size := len(queue)
		for i := 0; i < size; i++ {
			temp := queue[0]
			queue = queue[1:]
			check[temp.data] = true
			if temp.left != nil && !check[temp.left.data] {
				queue = append(queue, temp.left)
			}
			if temp.right != nil && !check[temp.right.data] {
				queue = append(queue, temp.right)
			}
			if _, ok := check[temp.data]; ok {
				queue = append(queue, &Node{data: temp.data})
			}
		}
		k--
	}

	for len(queue) > 0 {
		answer = append(answer, queue[0].data)
		queue = queue[1:]
	}

	return answer
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tStr, _ := reader.ReadString('\n')
	t, _ := strconv.Atoi(strings.TrimSpace(tStr))
	fmt.Println("started")
	for t > 0 {
		s, _ := reader.ReadString('\n')
		targetStr, _ := reader.ReadString('\n')
		kStr, _ := reader.ReadString('\n')
		target, _ := strconv.Atoi(strings.TrimSpace(targetStr))
		k, _ := strconv.Atoi(strings.TrimSpace(kStr))
		root := buildTree(strings.TrimSpace(s))
		res := KDistanceNodes(root, target, k)
		for _, val := range res {
			fmt.Print(val, " ")
		}
		fmt.Println()
		t--
	}
}
