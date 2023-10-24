/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func dfs(root *TreeNode, answer *[]int, level int) {
    if root == nil {
        return
    }
    level++
    if (len(*answer) == level) {
        *answer = append(*answer, root.Val)
    } else {
        (*answer)[level] = int(math.Max(float64((*answer)[level]), float64(root.Val)))
    }
    dfs(root.Left, answer, level)
    dfs(root.Right, answer, level)
}

func largestValues(root *TreeNode) []int {
    answer := make([]int, 0)
    dfs(root, &answer, -1)
    return answer
}