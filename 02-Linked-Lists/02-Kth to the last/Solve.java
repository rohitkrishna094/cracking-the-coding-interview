import java.util.*;

public class Solve {

    public static void main(String[] args) throws Exception {
        LinkedListNode ll = new LinkedListNode();
        ll.insertList(new int[]{1,2,3,4,5,6,7,8,9,10});
        ll.print();
        for(int i = 1; i <= 10; i++) {
            int k = i;
            System.out.println(getKthLast(ll, k));
        }
    }

    static int getKthLast(LinkedListNode ll, int k) throws Exception {
        if(k <= 0) {
            throw new Exception("Please enter a value >=1 and <= ll.getLength()");
        }
        
        Node ptr = ll.getHead();
        for(int i = 1; i < ll.getLength() - k + 1; i++) {
            
            ptr = ptr.next;
            if(ptr == null) throw new Exception("Please enter a value lower than ll.getLength()");
        }
        return ptr.data;

    }
}