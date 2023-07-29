
//User function Template for Java

class Tree
{
    public static void inorder(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    public static float findMedian(Node root)
    {
        // code here.
        List<Integer> list  = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        if(n%2!=0){
            return (float)list.get(n/2);
        }
        float  a = list.get(n/2);
        float  b = list.get((n/2)-1);
        return (float)((a+b)/2);
    }
}