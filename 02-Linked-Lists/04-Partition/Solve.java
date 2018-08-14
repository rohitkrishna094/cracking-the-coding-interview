import java.util.*;

// Doesn't work since my LinkedList adds a new node at head
public class Solve {

    public static void main(String[] args) {
        LinkedListNode ll = new LinkedListNode();
        ll.insertList(new int[]{1,2,10,5,8,5,3});
        ll.print();
        Node newNode = partition(ll.getHead(), 5);
        while(newNode != null) {
            System.out.print(newNode.data+", ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    static Node partition(Node node, int x) {
        Node head = node, tail = node;

        while(node != null) {
            Node next = node.next;
            if(node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }
}