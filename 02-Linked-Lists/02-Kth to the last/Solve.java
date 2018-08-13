import java.util.*;

public class Solve {

    public static void main(String[] args) {
        LinkedListNode ll = new LinkedListNode();
        ll.insertList(new int[]{1,2,3,4,5,6,7,8,9,10});
        ll.print();
        removeDups(ll.getHead());
        ll.print();
        System.out.println(getKthLast(ll.getHead()));
        
    }

    static int getKthLast(Node head) {

    }
}