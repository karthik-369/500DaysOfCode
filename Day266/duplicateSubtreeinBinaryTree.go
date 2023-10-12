package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

func buildTree(ip []string) *Node {
	queue := []*Node{}
	rootData, _ := strconv.Atoi(ip[0])
	root := &Node{data: rootData}
	queue = append(queue, root)
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

func pre(root *Node, m map[string]int) string {
	if root == nil {
		return "."
	}
	sb := strings.Builder{}
	if root.left == nil && root.right == nil {
		return fmt.Sprintf("%d ", root.data)
	}
	sb.WriteString(fmt.Sprintf("%d ", root.data))
	sb.WriteString(pre(root.left, m))
	sb.WriteString(pre(root.right, m))
	m[sb.String()]++
	return sb.String()
}

func dupSub(root *Node) int {
	m := make(map[string]int)
	pre(root.Left, m)
	pre(root.Right, m)
	for _, v := range m {
		if v > 1 {
			return 1
		}
	}
	return 0
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	tStr, _ := reader.ReadString('\n')
	t, _ := strconv.Atoi(strings.TrimSpace(tStr))
	for t > 0 {
		s, _ := reader.ReadString('\n')
		ip := strings.Fields(strings.TrimSpace(s))
		root := buildTree(ip)
		result := dupSub(root)
		fmt.Println(result)
		t--
	}
}
