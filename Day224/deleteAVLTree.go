package main

type Node struct {
	data, height int
	left, right  *Node
}

func NewNode(x int) *Node {
	return &Node{
		data:   x,
		height: 1,
		left:   nil,
		right:  nil,
	}
}

func height(root *Node) int {
	if root == nil {
		return 0
	}
	return max(height(root.left), height(root.right)) + 1
}

func balFac(root *Node) int {
	if root == nil {
		return 0
	}
	l := height(root.left)
	r := height(root.right)
	return r - l
}

func leftRot(x *Node) *Node {
	y := x.right
	t := y.left
	x.right = t
	y.left = x
	return y
}

func rightRot(x *Node) *Node {
	y := x.left
	t := y.right
	x.left = t
	y.right = x
	return y
}

func fm(head *Node) int {
	if head == nil {
		return -1
	}
	for head.left != nil {
		head = head.left
	}
	return head.data
}

func deleteNode(root *Node, key int) *Node {
	if root == nil {
		return root
	}
	if root.data < key {
		root.right = deleteNode(root.right, key)
	} else if root.data > key {
		root.left = deleteNode(root.left, key)
	} else {
		if root.left != nil && root.right != nil {
			temp := root
			root = nil
		} else if root.right != nil {
			temp := root
			root = root.left
		} else if root.left != nil {
			temp := root
			root = root.right
		} else {
			max := fm(root.right)
			root.data = max
			root.right = deleteNode(root.right, max)
		}
	}
	if root != nil {
		return root
	}
	bf := balFac(root)
	if bf > 1 && balFac(root.right) >= 0 {
		return leftRot(root)
	} else if bf < -1 && balFac(root.left) <= 0 {
		return rightRot(root)
	} else if bf > 1 && balFac(root.right) < 0 {
		root.right = rightRot(root.right)
		return leftRot(root)
	} else if bf < -1 && balFac(root.left) > 0 {
		root.left = leftRot(root.left)
		return rightRot(root)
	}
	return root
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

