package main

import (
	"fmt"
	"sort"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

type Solution struct {
	count int
	list  []int
}

func (s *Solution) getCount(node *Node, bud int) int {
	s.list = make([]int, 0)
	s.inorder(node)
	sort.Ints(s.list)
	answer := 0
	sum := 0
	for i := 0; i < len(s.list); i++ {
		if sum+s.list[i] <= bud {
			sum += s.list[i]
			answer++
		}
	}
	return answer
}

func (s *Solution) inorder(root *Node) {
	if root == nil {
		return
	}
	s.count++
	s.inorder(root.left)
	if root.left == nil && root.right == nil {
		s.list = append(s.list, s.count)
	}
	s.inorder(root.right)
	s.count--
}



