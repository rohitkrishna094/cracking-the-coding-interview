import java.util.*;


// incomplete coz linkedlist runs in opposite direction
public class Solve {

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode();
        LinkedListNode l2 = new LinkedListNode();
        l1.insertList(new int[]{7,1,6});
        l2.insertList(new int[]{5,9,2});
        l1.print();
        l2.print();
        LinkedListNode res = sumLists(l1.getHead(), l2.getHead());
        res.print();
    }

    static LinkedListNode sumLists(Node l1, Node l2) {
        int carry = 0;
        LinkedListNode ll = new LinkedListNode();
        while(l1 != null && l2 != null) {
            System.out.println(l1.data);
            int temp = l1.data + l2.data + carry;
            carry = temp % 10;
            temp /= 10;
            ll.insertAtTail(temp);
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null) {
            while(l1 != null) {
                int temp = l1.data + carry;
                carry = temp % 10;
                temp /= 10;
                ll.insertAtTail(temp);
                l1 = l1.next;
            }
        }
        if(l2 != null) {
            while(l2 != null) {
                int temp = l2.data + carry;
                carry = temp % 10;
                temp /= 10;
                ll.insertAtTail(temp);
                l1 = l2.next;
            }
        }
        if(carry == 1) {
            ll.insertAtTail(1);
        }
        
        return ll;
    }
   
}