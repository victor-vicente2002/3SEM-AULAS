public class ListObj<T>{

    private T[] vector;
    private int vectorNum;


    public ListObj(int size) {
        this.vector = (T[]) new Object[size];
        this.vectorNum = 0;
    }

    public boolean add(T object) {
        if (vectorNum >= vector.length) {
            System.out.println("Lista está cheia");
            return false;
        }
        else {
            vector[vectorNum++] = object;
            return true;
        }
    }

    public void getList() {
        System.out.println("\nExibindo elementos da lista:");
        for (int i=0; i< vectorNum; i++) {
            System.out.println(vector[i] + "\t");
        }
        System.out.println();
    }

    public int getValue(T object) {
        for (int i=0; i < vectorNum; i++) {
            if (vector[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= vectorNum) { return false; }
        else {

            for (int i = index; i < vectorNum - 1; i++) {
                vector[i] = vector[i+1];
            }
            vectorNum --;
            return true;
        }
    }

    public boolean removeElement(T object) {
        return this.removeByIndex(this.getValue(object));
    }

    public int getSize() {
        return vectorNum;
    }

    public T getElement(int index) {
        if (vectorNum > index) {
            return vector[index];
        }
        else{ return null; }
    }

    public void cleanList() {
        vectorNum = 0;
        System.out.println("Lista limpa com sucesso!");
    }

    public boolean isEmpty() {
        return vectorNum == 0? true : false;
    }

    public boolean changeByIndex(int index, T object){
        if (getElement(index).equals(null) || index < 0){
            System.out.println("Não existe esse índice!");
            return false;
        }else{
            vector[index] = object;
            System.out.println("Objeto trocado");
            return true;
        }
    }
}
