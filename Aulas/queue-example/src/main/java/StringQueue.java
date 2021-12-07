public class StringQueue {
    private int size;
    private String[] queue;

    public StringQueue(int maxSize) {
        this.queue = new String[maxSize];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= this.queue.length;
    }

    public void insert(String newString){
        if (!isFull()){
            queue[size++] = newString;
        }else{
            System.out.println("The Queue is full!");
        }
    }

    public String poll(){
        if (!isEmpty()){
            String excluded = queue[0];
            for (int i=0 ;i < size - 1 ;i++){
                queue[i] = queue[i+1];
            }
            size--;
            return excluded;
        }else{
            System.out.println("Queue is empty!");
            return null;
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return queue[0];
        }else{
            System.out.println("Queue is empty!");
            return null;
        }
    }

    public void getAllQueue() {
        if (!isEmpty()){
            for (int i=0; i<size; i++){
                System.out.println(queue[i]);
            }
        }
    }
}
