type Node struct {
	data int
	left *Node
	right *Node
}


func isIsomorphic(root1 *Node, root2 *Node) bool {
	if root1 == nil && root2 == nil {
		return true
	}
	if root1 == nil || root2 == nil || root1.data != root2.data {
		return false
	}
	return (isIsomorphic(root1.left, root2.right)&&isIsomorphic(root1.right, root2.left) || (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)))
}