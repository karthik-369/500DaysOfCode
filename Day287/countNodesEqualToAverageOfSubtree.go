/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func inorder(root *TreeNode, sum *int, count *int) {
    if root == nil {
        return
    }
    inorder(root.Left, sum,count)
    *sum += root.Val
    *count++
    inorder(root.Right, sum,count)
}

func averageOfSubtree(root *TreeNode) int {
    queue := make([]*TreeNode, 0)
    answer := 0
    queue = append(queue, root)
    for len(queue) > 0 {
        // for _, v := range queue {
        //     fmt.Println(v.Val)
        // }
        sum := 0
        count := 0
        temp := queue[0]
        queue  = queue[1:]
        inorder(temp, &sum, &count)
        // fmt.Println(sum)
        if temp.Val == sum/count {
            answer++
        }
        if temp.Left != nil {
            queue = append(queue, temp.Left)
        }
        if temp.Right != nil {
            queue = append(queue, temp.Right)
        }
    }
    return answer
}