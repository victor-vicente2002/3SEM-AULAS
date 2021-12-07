public class Exercise3 {
    public static void main(String[] args) {
        StackGeneric<String> stringStack = new StackGeneric<>(10);
        stringStack.push("Shablau!");
        stringStack.push("string segunda");
        stringStack.push("tchubiraudaum");

        stringStack.getAllStack();
        System.out.println();
        System.out.println(stringStack.peek());
    }
}
