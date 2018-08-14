public class Driver {
    public static void main(String[] args) throws Exception{
        MyQueue<String> mq = new MyQueue<>();
        mq.add("luffy");
        mq.add("zoro");
        mq.add("usopp");
        mq.add("sanji");
        mq.add("nami");

        while(!mq.isEmpty()) {
            String s = mq.remove();
            System.out.println(s);
        }
    }
}