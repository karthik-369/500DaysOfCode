import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class Solution {
    public int fre;
    public int temp = 0;
    public int maxCount = 0;
    public List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        temp = (node.val == fre) ? temp + 1 : 1;
        if (temp == maxCount) {
            list.add(node.val);
        } else if (temp > maxCount) {
            maxCount = temp;
            list.clear();
            list.add(node.val);
        }
        fre = node.val;

        inorder(node.right);
    }
}