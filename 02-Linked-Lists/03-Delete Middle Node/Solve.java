import java.util.*;

public class Solve {

    public static void main(String[] args) {
        LinkedListNode ll = new LinkedListNode();
        ll.insertList(new int[]{1,2,3,4,5,6,7,8,9,10});
        ll.print();
        // delete 7
        deleteMiddleNode(ll.getHead().next.next.next);
        ll.print();
    }

    static boolean deleteMiddleNode(Node node) {
        if(node == null || node.next == null) return false;
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        return true;
    }
}