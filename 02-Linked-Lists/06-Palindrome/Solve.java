import java.util.*;

public class Solve {

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode();
        LinkedListNode l2 = new LinkedListNode();
        int[] a = {1,2,3,2,1};
        // int[] a = {1,2,2,1};
        l1.insertList(a);
        l1.print();
        boolean res = isPalindrome(l1.getHead());
        System.out.println(res);
    }

    static boolean isPalindrome(Node head) {
        Stack<Integer> stack = new Stack<Integer>();
        Node ptr1 = head, ptr2 = head;
        while(ptr2.next != null && ptr2.next.next != null) {
            stack.push(ptr1.data);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        if(ptr2.next != null) {
            stack.push(ptr2.data);
        }
        ptr1 = ptr1.next;
        while(ptr1 != null) {
            int pull = stack.pop();
            if(pull != ptr1.data) return false;
            ptr1 = ptr1.next;
        }
        return true;
    }
   
}