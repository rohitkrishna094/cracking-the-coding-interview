import java.util.*;

// bug involved check once
public class Solve {

    public static void main(String[] args) {
        LinkedListNode ll = new LinkedListNode();
        ll.insertList(new int[]{1,2,3,4,5,3});
        ll.print();
        Node node = loopDetect(ll.getHead());
        System.out.println(node);
    }

    // from ctci repo
    static Node loopDetect(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // collision
            if(slow == fast) { 
                break;
            }
        }

        if(fast == null || fast.next == null) return null;

        // move slow to head. keep fast at meeting point. each are k steps
        // from the loop start. if they move at the same pace, they must
        // meet at loop start
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // both now point to the start of the loop
        return fast;
    }
   
}