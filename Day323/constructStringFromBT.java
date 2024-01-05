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
    public String preOrder(TreeNode root) {
        if (root == null) {
            return "";
        }
        String answer = String.valueOf(root.val);
        if (root.left != null || root.right != null) {
            answer += "(" + preOrder(root.left) + ")";
        }
        if (root.right != null) {
            answer += "(" + preOrder(root.right) + ")";
        }
        return answer;
    }
    public String tree2str(TreeNode root) {
        return preOrder(root);
    }
}