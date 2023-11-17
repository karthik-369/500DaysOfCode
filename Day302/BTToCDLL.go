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

type Solution struct {
	head *Node
	tail *Node
}

func (sol *Solution) bTreeToClist(root *Node) *Node {
	if root == nil {
		return nil
	}

	sol.bTreeToClist(root.left)

	if sol.head == nil {
		sol.head = root
	} else {
		sol.tail.right = root
		root.left = sol.tail
	}

	sol.tail = root

	sol.bTreeToClist(root.right)

	sol.tail.right = sol.head
	sol.head.left = sol.tail

	return sol.head
}

func displayCList(head *Node) {
	itr := head
	for {
		fmt.Print(itr.data, " ")
		itr = itr.right
		if itr == head {
			break
		}
	}
	fmt.Println()

	itr = itr.left
	head = itr
	for {
		fmt.Print(itr.data, " ")
		itr = itr.left
		if head == itr {
			break
		}
	}
	fmt.Println()
}

func buildTree(str string) *Node {
	if len(str) == 0 || str[0] == 'N' {
		return nil
	}

	ip := strings.Split(str, " ")
	root := &Node{}
	queue := []*Node{}

	root.data, _ = strconv.Atoi(ip[0])
	queue = append(queue, root)
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

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < t; i++ {
		scanner.Scan()
		s := scanner.Text()
		root := buildTree(s)

		obj := Solution{}
		head := obj.bTreeToClist(root)
		displayCList(head)
	}
}
