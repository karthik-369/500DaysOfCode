package Day185;
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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n==1){
            List<TreeNode> temp = new ArrayList<>();
            temp.add(new TreeNode(0));
            return temp;
        }
        List<TreeNode> answer = new ArrayList<>();
        for(int i=1;i<n;i+=2){
            List<TreeNode> left =  allPossibleFBT(i);
            List<TreeNode> right =  allPossibleFBT(n-i-1);
            for(TreeNode le: left){
                for(TreeNode ri: right){
                    TreeNode root = new TreeNode(0);
                    root.left = le;
                    root.right=ri;
                    answer.add(root);
                }
            }
        }
        return answer;
    }
}