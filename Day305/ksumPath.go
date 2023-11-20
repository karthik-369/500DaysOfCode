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

type Solution struct {
	mapping map[int]int
	answer  int
}

func (sol *Solution) sumK(root *Node, k int) int {
	sol.mapping = make(map[int]int)
	sol.answer = 0
	sol.dfs(root, k, 0)
	return sol.answer
}

func (sol *Solution) dfs(root *Node, k, count int) {
	if root == nil {
		return
	}
	count += root.data
	if count == k {
		sol.answer++
	}
	if val, exists := sol.mapping[count-k]; exists {
		sol.answer += val
	}
	sol.mapping[count]++
	sol.dfs(root.left, k, count)
	sol.dfs(root.right, k, count)
	sol.mapping[count]--
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t, _ := strconv.Atoi(scanner.Text())

	for t > 0 {
		scanner.Scan()
		s := scanner.Text()
		root := buildTree(s)

		scanner.Scan()
		k, _ := strconv.Atoi(scanner.Text())

		ob := Solution{}
		result := ob.sumK(root, k)
		fmt.Println(result)

		t--
	}
}
