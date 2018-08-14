public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data) {
        QueueNode<T> newNode = new QueueNode<T>(data);
        if(last != null) last.next = newNode;
        last = newNode;
        if(first == null) first = last;
    }

    public T remove() throws Exception{
        if(first == null) throw new Exception("Empty Queue Exception");
        T data = first.data;
        first = first.next;
        if(first == null) last = null;
        return data;
    }

    public T peek() throws Exception{
        if(first == null) throw new Exception("Empty Queue Exception");
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}