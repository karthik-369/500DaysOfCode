/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sum;
    public void preorder(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val <= high && root.val >= low) {
            sum += root.val;
        }
        preorder(root.left, low, high);
        preorder(root.right, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        preorder(root, low, high);
        return sum;
    }
}