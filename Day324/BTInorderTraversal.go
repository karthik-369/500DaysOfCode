/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func inorder(root *TreeNode, answer *[]int) {
    if root == nil {
        return 
    }
    inorder(root.Left, answer)
    *answer = append(*answer, root.Val)
    inorder(root.Right, answer)
}
func inorderTraversal(root *TreeNode) []int {
    answer := make([]int , 0)
    inorder(root, &answer)
    return answer
}