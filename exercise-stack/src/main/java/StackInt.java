public class StackInt {
    int top = -1;
    int[] stack;

    public StackInt(int size) {
        stack = new int[size];
    }

    public boolean isEmpty() {
//        if (top == -1){
//            return true;
//        }else { return false; }
        return top == -1;
    }

    public boolean isFull() {
//        if (top >= stack.length - 1) {
//            return true;
//        }else { return false; }
        return top >= stack.length -1;
    }

    public void push(int element) {
        if (!isFull()){
            stack[++top] = element;
        }else {
            System.out.println("A pilha já está cheia!");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        }else {
            System.out.println("A pilha está vazia!");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()){
            return stack[top];
        }
        else {
            System.out.println("A pilha está vazia");
            return -1;
        }
    }

    public void getAllStack() {
        if (!isEmpty()){
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i]+"\t");
            }
        }else {
            System.out.println("Pilha está vazia");
        }
    }

}

