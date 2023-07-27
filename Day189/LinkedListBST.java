class Solution {
    public boolean path(ListNode head, TreeNode root){
        if(head == null){
            return true;
        }
        if(root == null){
            return false;
        }
        return head.val == root.val && (path(head.next, root.left)||path(head.next, root.right));
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null){
            return false;
        }
        if(head == null){
            return true;
        }
        return path(head, root)|| isSubPath(head,root.left) || isSubPath(head, root.right);
    }
}