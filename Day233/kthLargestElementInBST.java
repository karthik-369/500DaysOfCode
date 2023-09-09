package Day233;

import java.util.ArrayList;
import java.util.List;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution

{
    int answer = -1;
    int count = 0;
    public void inorder(Node root, int k) {
        if (root == null || count >=k) {
            return;
        }
        inorder(root.right, k);
        count++;
        if (count == k) {
            answer = root.data;
            return;
        }
        inorder(root.left, k);
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        inorder(root, K);
        return answer;
    }
}