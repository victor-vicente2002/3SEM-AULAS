public class StackGeneric<T> {
    int top = -1;
    T[] stack;

    public StackGeneric(int size) {
        stack = (T[]) new Object[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top >= stack.length -1;
    }

    public void push(T element) {
        if (!isFull()){
            stack[++top] = element;
        }else {
            System.out.println("A pilha já está cheia!");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return stack[top--];
        }else {
            System.out.println("A pilha está vazia!");
            return null;
        }
    }

    public T peek() {
        if (!isEmpty()){
            return stack[top];
        }
        else {
            System.out.println("A pilha está vazia");
            return null;
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
