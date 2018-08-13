import java.util.*;

public class Solve {

    public static void main(String[] args) {
        LinkedListNode ll = new LinkedListNode();
        ll.insertList(new int[]{1,2,3,4,4,5,3,6,2,4,1});
        ll.print();
        removeDups(ll.getHead());
        ll.print();
        ll.delete(5);
        ll.print();
    }

    static void removeDups(Node head) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node ptr = head, prev = null;
        while(ptr != null) {
            if(set.contains(ptr.data)) {
                prev.next = ptr.next;
            } else {
                set.add(ptr.data);
                prev = ptr;
            }
            ptr = ptr.next;
        }
    }
}