public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() throws Exception{
        if(top == null) throw new Exception("Empty Stack Exception");
        T data = top.data;
        top = top.next;
        return data;
    }

    public void push(T item) {
        StackNode<T> newNode = new StackNode<T>(item);
        newNode.next = top;
        top = newNode;
    }

    public T peek() throws Exception{
        if(top == null) throw new Exception("Empty Stack Exception");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }


}