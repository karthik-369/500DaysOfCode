


//User function Template for Java

/*
class Node
{
	int data, height;
	Node left, right;
	Node(int x)
	{
		data = x;
		height = 1;
		left = right = NULL;
	}
}
*/
class Sol
{
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    static int balFac(Node root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return r - l;
    }
    static Node leftRot(Node x) {
        Node y = x.right;
        Node t = y.left;
        x.right = t;
        y.left = x;
        return y;
    }
    static Node rightRot(Node x) {
        Node y = x.left;
        Node t = y.right;
        x.left = t;
        y.right = x;
        return y;
    }
    static int  fm(Node head) {
        if (head == null) {
            return -1;
        }
        while (head.left != null) {
            head = head.left;
        }
        return head.data;
    }
    
    public static Node deleteNode(Node root, int key)
    {
        // code here.
        if (root == null) {
            return root;
        }
        if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if ( root.left != null && root.right != null) {
                Node temp = root;
                root = null;
            } else if(root.right != null) {
                Node temp = root;
                root = root.left;
            } else if (root.left != null) {
                Node temp = root;
                root = root.right;
            } else {
                int max = fm(root.right);
                root.data = max;
                root.right = deleteNode(root.right, max);
            }
        }
        if (root != null) {
            return root;
        }
        int bf = balFac(root);
        if (bf >1 && balFac(root.right )>= 0) {
            return leftRot(root);
        } else if (bf <-1 && balFac(root.left)<=0) {
            return rightRot(root);
        } else if (bf >1 && balFac(root.right)<0) {
            root.right = rightRot(root.right);
            return leftRot(root);
        } else if (bf<-1 && balFac(root.left)>0) {
            root.left = leftRot(root.left);
            return rightRot(root);
        }
        return root;
    }
}