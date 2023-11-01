/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func inorder(root *TreeNode, m map[int]int) {
    if root == nil {
        return
    }
    inorder(root.Left, m)
    m[root.Val]++
    inorder(root.Right, m)
}
func findMode(root *TreeNode) []int {
    m := make(map[int]int)
    inorder(root, m)
    max := -1
    for _,v := range m {
        max = int(math.Max(float64(max), float64(v)))
    }
    answer := make([]int, 0)
    for k,v := range m {
        if v == max {
            answer = append(answer, k)
        }
    }
    return answer
}