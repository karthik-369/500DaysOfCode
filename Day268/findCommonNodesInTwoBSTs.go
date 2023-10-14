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

func findCommon(root1, root2 *Node) []int {
	answer := []int{}
	stack1 := []*Node{}
	stack2 := []*Node{}

	for len(stack1) > 0 || len(stack2) > 0 || root1 != nil || root2 != nil {
		for root1 != nil {
			stack1 = append(stack1, root1)
			root1 = root1.left
		}
		for root2 != nil {
			stack2 = append(stack2, root2)
			root2 = root2.left
		}

		if len(stack1) > 0 && len(stack2) > 0 {
			node1 := stack1[len(stack1)-1]
			node2 := stack2[len(stack2)-1]

			if node1.data == node2.data {
				answer = append(answer, node1.data)
				stack1 = stack1[:len(stack1)-1]
				stack2 = stack2[:len(stack2)-1]
				root1 = node1.right
				root2 = node2.right
			} else if node1.data < node2.data {
				stack1 = stack1[:len(stack1)-1]
				root1 = node1.right
			} else {
				stack2 = stack2[:len(stack2)-1]
				root2 = node2.right
			}
		} else {
			break
		}
	}
	return answer
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t, _ := strconv.Atoi(scanner.Text())

	for t > 0 {
		scanner.Scan()
		input1 := scanner.Text()
		root1 := buildTree(input1)

		scanner.Scan()
		input2 := scanner.Text()
		root2 := buildTree(input2)

		result := findCommon(root1, root2)
		fmt.Println(strings.Trim(strings.Join(strings.Fields(fmt.Sprint(result)), " "), "[]"))
		t--
	}
}
