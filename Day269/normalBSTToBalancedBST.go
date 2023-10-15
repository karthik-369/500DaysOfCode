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

type GfG struct {
	list []int
}

func (g *GfG) inorder(root *Node) {
	if root == nil {
		return
	}
	g.inorder(root.left)
	g.list = append(g.list, root.data)
	g.inorder(root.right)
}

func (g *GfG) buildBalancedTree(list []int, l, h int) *Node {
	if l > h {
		return nil
	}
	mid := l + (h-l)>>1
	root := &Node{data: list[mid]}
	root.left = g.buildBalancedTree(list, l, mid-1)
	root.right = g.buildBalancedTree(list, mid+1, h)
	return root
}

func (g *GfG) buildBalancedBST(root *Node) *Node {
	g.list = []int{}
	g.inorder(root)
	return g.buildBalancedTree(g.list, 0, len(g.list)-1)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t, _ := strconv.Atoi(scanner.Text())

	for t > 0 {
		scanner.Scan()
		input := scanner.Text()
		root := buildTree(input)

		gfg := GfG{}
		newRoot := gfg.buildBalancedBST(root)
		preOrder(newRoot)
		fmt.Println()

		t--
	}
}

func buildTree(input string) *Node {
	inputArr := strings.Fields(input)
	if len(inputArr) == 0 || inputArr[0] == "N" {
		return nil
	}

	rootValue, _ := strconv.Atoi(inputArr[0])
	root := &Node{data: rootValue}
	queue := []*Node{root}
	index := 1
	for index < len(inputArr) && len(queue) > 0 {
		currentNode := queue[0]
		queue = queue[1:]

		leftValue := inputArr[index]
		index++
		if leftValue != "N" {
			left, _ := strconv.Atoi(leftValue)
			currentNode.left = &Node{data: left}
			queue = append(queue, currentNode.left)
		}

		if index >= len(inputArr) {
			break
		}

		rightValue := inputArr[index]
		index++
		if rightValue != "N" {
			right, _ := strconv.Atoi(rightValue)
			currentNode.right = &Node{data: right}
			queue = append(queue, currentNode.right)
		}
	}
	return root
}

func preOrder(root *Node) {
	if root == nil {
		return
	}
	fmt.Print(root.data, " ")
	preOrder(root.left)
	preOrder(root.right)
}






