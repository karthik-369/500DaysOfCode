package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

func insert(root *Node, val int) *Node {
	if root == nil {
		return &Node{data: val}
	}

	if val < root.data {
		root.left = insert(root.left, val)
	} else if val > root.data {
		root.right = insert(root.right, val)
	}

	return root
}

func floor(root *Node, x int) int {
	answer := -1
	var flat func(*Node, int)
	flat = func(root *Node, x int) {
		if root == nil {
			return
		}
		flat(root.left, x)
		if answer <= root.data && root.data <= x {
			answer = root.data
		}
		flat(root.right, x)
	}
	flat(root, x)
	return answer
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanWords)

	scanner.Scan()
	T, _ := strconv.Atoi(scanner.Text())

	for t := 0; t < T; t++ {
		scanner.Scan()
		n, _ := strconv.Atoi(scanner.Text())

		var root *Node
		for i := 0; i < n; i++ {
			scanner.Scan()
			k, _ := strconv.Atoi(scanner.Text())
			root = insert(root, k)
		}

		scanner.Scan()
		s, _ := strconv.Atoi(scanner.Text())

		ans := floor(root, s)
		fmt.Println(ans)
	}
}
