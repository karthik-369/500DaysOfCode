/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public Map<TreeNode , TreeNode> graph;
    public List<Integer> answer;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        answer = new  ArrayList<>();
        map(root);
        dfs(target, null, k);
        return answer;
    }
    public void map(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left!=null){
            graph.put(root.left, root);
        }
        if(root.right != null){
            graph.put(root.right, root);
        }
        map(root.left);
        map(root.right);
    }
    public void dfs(TreeNode root, TreeNode prev, int k){
        if(root == null){
            return;
        }
        if(k==0){
            answer.add(root.val);

        }
        if(graph.containsKey(root) && graph.get(root)!=prev){
            dfs(graph.get(root), root, k-1);
        }
        if(root.left!=prev){
            dfs(root.left, root, k-1);
        }
        if(root.right!=prev){
            dfs(root.right, root, k-1);
        }
    }
}