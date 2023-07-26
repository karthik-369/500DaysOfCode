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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }
    public void print(TreeNode root, int row, int l, int r, List<List<String>> answer){
        if(root==null){
            return;
        }
        int mid = l + (r-l)/2;
        answer.get(row).set(mid, String.valueOf(root.val));
        print(root.left, row+1, l, mid-1, answer);
        print(root.right, row+1, mid+1, r, answer);
    }
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int w = (int)Math.pow(2,h)-1;   
        List<List<String>> answer = new ArrayList<>();
        for(int i=0;i<h;i++){
            answer.add(new ArrayList<>());
            for(int j=0;j<w;j++){
                answer.get(i).add("");
            }
        }
        print(root, 0, 0, w-1, answer);
        return answer;
    }
}