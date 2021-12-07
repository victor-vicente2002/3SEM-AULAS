public class MainClass {
    public static void main(String[] args) {
        StackInt stack = new StackInt(10);

        stack.push(1);
        stack.push(34);
        stack.push(5);
        stack.push(20);
        stack.push(34);
        stack.push(12);
        stack.push(7);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println();
        System.out.println(stack.peek());

        System.out.println();
        stack.getAllStack();
    }
}
