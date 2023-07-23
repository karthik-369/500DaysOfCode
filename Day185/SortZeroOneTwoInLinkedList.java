package Day185;
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        int arr[] = new int[3];
        while(head!=null){
            arr[head.data]++;
            head = head.next;
        }
        Node answer = new Node(-1);
        Node tail = answer;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i];j++){
                Node temp = new Node(i);
                tail.next = temp;
                tail = temp;
            }
        }
        return answer.next;
    }
}
