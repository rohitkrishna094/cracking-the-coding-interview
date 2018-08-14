public class Driver {
    public static void main(String[] args) throws Exception {
        MyStack<String> ms = new MyStack<>();
        ms.push("luffy");
        ms.push("zoro");
        ms.push("usopp");
        ms.push("sanji");
        ms.push("nami");

        while(!ms.isEmpty()) {
            String s = ms.pop();
            System.out.println(s);
        }
    }
}