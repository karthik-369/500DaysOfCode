//{ Driver Code Starts
//Initial Template for Java
package Day264;
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class nodeAtGivenDistanceBT
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0 ;i<size; i++) {
                Node temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                    map.put(temp.left.data, temp);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    map.put(temp.right.data, temp);
                }
            }
        }
        dfs(root, target, queue);
        Map<Integer, Integer> check = new HashMap<>();
        while (k >0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node temp = queue.poll();
                check.put(temp.data, 1);
                if (temp.left!=null && !check.containsKey(temp.left.data)) {
                    queue.add(temp.left);
                }
                if (temp.right != null && !check.containsKey(temp.right.data)){
                    queue.add(temp.right);
                }
                if (map.containsKey(temp.data) && !check.containsKey(map.get(temp.data).data)){
                    queue.add(map.get(temp.data));
                }
            }
            k--;
        }
        while(!queue.isEmpty()) {
            answer.add(queue.poll().data);
        }
        Collections.sort(answer);
        return answer;
    }
    
    public static void dfs(Node root, int target , Queue<Node> queue) {
        if (root == null) {
            return;
        }
        if (root.data == target) {
            queue.add(root);
            return;
        }
        dfs(root.left, target, queue);
        dfs(root.right, target, queue);
        return;
    }
};