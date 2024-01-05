/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 func preOrder(root *TreeNode) string {
    if root == nil {
        return ""
    }
    answer := strconv.FormatInt(int64(root.Val),10)
    if root.Left != nil || root.Right != nil {
        answer += "(" + preOrder(root.Left)+")"
    }
    if root.Right != nil {
        answer += "(" + preOrder(root.Right)+")"
    }
    return answer
}
func tree2str(root *TreeNode) string {
    return preOrder(root)
}