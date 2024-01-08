/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 func inorder(root *TreeNode, sum *int, low int, high int) {
    if root == nil {
        return
    }
    inorder(root.Left,sum, low, high)
    // *list = append(*list, root.Val)
    if root.Val >= low && root.Val <= high {
        *sum += root.Val
    }
    inorder(root.Right, sum, low, high)
}
func rangeSumBST(root *TreeNode, low int, high int) int {
    sum := 0
    // list := make([]int, 0)
    inorder(root,  &sum, low, high)
    // fmt.Println(list)
    return sum
}