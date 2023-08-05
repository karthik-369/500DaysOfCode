package Day198;

import java.util.ArrayList;
import java.util.List;




// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<TreeNode> build(int s, int e){
        List<TreeNode> answer = new ArrayList<>();
        if(s>e){
            answer.add(null);
            return answer;
        }
        for(int i=s;i<=e;i++){
            List<TreeNode> left = build(s, i-1);
            List<TreeNode> right = build(i+1, e);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode temp = new TreeNode(i);
                    temp.left = left.get(j);
                    temp.right = right.get(k);
                    answer.add(temp);
                }
            }
        }
        return answer;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return build(1, n);
    }
}