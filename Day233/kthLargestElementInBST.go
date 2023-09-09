package main



type Node struct {
	data  int
	left  *Node
	right *Node
}

type Solution struct {
	list []int
}

func (s *Solution) kthLargest(root *Node, K int) int {
	s.list = make([]int, 0)
	s.inorder(root)
	return s.list[len(s.list)-K]
}

func (s *Solution) inorder(root *Node) {
	if root == nil {
		return
	}
	s.inorder(root.left)
	s.list = append(s.list, root.data)
	s.inorder(root.right)
}


