class Solution{
    int count = 0;
    List<Integer> list;
    public int getCount(Node node, int bud)
    {
        //code here  
        list = new ArrayList<>();
        inorder(node);
        Collections.sort(list);
        int answer = 0;
        int sum = 0;
        for (int i=0; i<list.size(); i++) {
            if (sum+list.get(i)<=bud) {
                sum+= list.get(i);
                answer++;
            }
        }
        // System.out.println(list);
        return answer;
    }
    
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        count+=1;
        inorder(root.left);
        if (root.left == null && root.right == null) {
            list.add(count);
        }
        inorder(root.right);
        count--;
        
    }
}