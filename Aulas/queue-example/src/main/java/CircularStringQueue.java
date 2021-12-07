public class CircularStringQueue {

    private int size;
    private String[] queue;
    private int begin;
    private int end;

    public CircularStringQueue(int maxSize) {
        this.queue = new String[maxSize];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size >= this.queue.length;
    }

    public void insert(String newString) {
        if (!isFull()) {
            queue[this.end] = newString;
            this.end = (this.end + 1) % this.size;
            size++;
        }else{
            System.out.println("Queue is already full!");
        }
    }

    public String poll() {
        if (!isEmpty()){
            String initValue = queue[this.begin];
            this.begin = (this.begin + 1) % this.size;
            size--;
            return initValue;
        }else {
            System.out.println("Queue is already full!");
            return null;
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return queue[this.begin];
        }else {
            System.out.println("Queue is empty!");
            return null;
        }
    }

    public void getAllQueue() {

    }
}
