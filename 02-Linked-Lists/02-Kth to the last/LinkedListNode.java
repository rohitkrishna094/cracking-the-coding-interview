public class LinkedListNode {
    Node head;

    public void insert(int a) {
        Node newNode = new Node(a);
        if(head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertList(int[] a) {
        for(int i = 0; i < a.length; i++) {
            this.insert(a[i]);
        }
    }

    public boolean delete(int a) {
       Node ptr = head, prev = null;

       if(ptr != null && ptr.data == a) {
           head = ptr.next;
           return true;
       }

       while(ptr != null && ptr.data != a) {
            prev = ptr;
            ptr = ptr.next;
       }

       if(ptr == null) return false;
       else {
           prev.next = ptr.next;
           ptr.next = null;
           return true;
       }
    }

    public void print() {
        Node ptr = head;
        while(ptr != null) {
            System.out.print(ptr.data + ", ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }
}
