public class MainClass {
    public static void main(String[] args) {
        StringQueue queue = new StringQueue(10);
        queue.insert("eu");
        queue.insert("tu");
        queue.insert("ele");

        queue.getAllQueue();

        queue.poll();
        queue.getAllQueue();

        System.out.println(queue.peek());
    }
}
