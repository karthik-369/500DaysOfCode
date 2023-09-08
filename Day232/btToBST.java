class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    public int i = 0;
     Node binaryTreeToBST(Node root)
    {
       // Your code here
       List<Integer> list = new ArrayList<>();
       traverse(root,list);
       Collections.sort(list);
       inorder(root,list);
       return root;
    }
    void traverse(Node root, List<Integer> list){
        if(root == null)
        return;
        list.add(root.data);
        traverse(root.left,list);
        traverse(root.right,list);
    }
    void inorder(Node root, List<Integer> list){
        if(root == null)
        return;
        inorder(root.left,list);
        root.data = list.get(i);
        i++;
        inorder(root.right,list);
    }
}
 