
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
//  Definition for singly-linked list.

class ListNode {
    int data;
    ListNode next;
    public ListNode() {

    }
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    ListNode root = new ListNode();
    void insert(List<Integer> list) {
        ListNode head = root;
        ListNode tail = root;
        for (int i=0; i<list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
    }
    
    void print() {
        if(root == null) {
            System.out.println("Empty list");
        }else {
            ListNode temp = root;
            while(temp != null) {
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }
    ListNode partition() {
        ListNode head = root;
        int x = 3;
        ListNode listOne = new ListNode(0);
        ListNode listTwo = new ListNode(0);
        ListNode head1 = listOne;
        ListNode head2 = listTwo;
        while (head!=null) {
            if (head.data<x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        head2.next = null;
        head1.next = listTwo.next;
        return listOne.next;
    }
}


public class PartitionInList {
    public static void main(String[] args) {
        int x = 3;
        List<Integer> list = new ArrayList<>(Arrays.asList(1,4,3,2,5,2));
        LinkedList ln = new LinkedList();
        ln.insert(list);
        ln.print();
        ListNode after = ln.partition();
        ln.print();
    }
}