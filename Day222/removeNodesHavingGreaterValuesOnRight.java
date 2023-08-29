

class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}

class removeNodesHavingGreaterValuesOnRight
{
    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    Node compute(Node head)
    {
        // your code here
        Node temp = reverse(head);
        Node curr = temp, prev = temp;
        while (curr.next!=null) {
            if (curr.next.data >= prev.data) {
                prev.next = curr.next;
                prev = prev.next;
            }
            curr = curr.next;
        }
        prev.next = null;
        return reverse(temp);
    }
}
  