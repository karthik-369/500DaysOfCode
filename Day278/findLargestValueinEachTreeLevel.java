import java.util.ArrayList;
import java.util.List;

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
    List<Integer> answer;
    public List<Integer> largestValues(TreeNode root) {
        answer = new ArrayList<>();
        dfs(root, -1);
        return answer;
    }
    public void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        level++;
        if (answer.size() == level) {
            answer.add(root.val); 
        } else {
            answer.set(level, Math.max(root.val, answer.get(level)));
        }
        dfs(root.left, level);
        dfs(root.right, level);
    }
}
 public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max  =Integer.MIN_VALUE;
            List<Integer> t = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    max = Math.max(max, temp.val);
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
            }
            answer.add(max);
        }
        return answer;
    }
}