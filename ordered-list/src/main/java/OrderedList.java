public class OrderedList {
    // Atributos
    private int[] vector;
    private int elementNum;

    public OrderedList(int size) {
        vector= new int[size];
        elementNum= 0;
    }

    public boolean add(int value) {
        boolean biggestNum = false;
        if (elementNum <= vector.length) {
            if (elementNum == 0){
                vector[0] = value;
                elementNum++;
            }else{
                for (int i=0;i<elementNum;i++) {
                    if (value < vector[i]) {
                        for (int j = elementNum; j > i; j--) {
                            vector[j] = vector[j-1];
                        }
                        vector[i] = value;
                        elementNum++;
                        biggestNum = false;
                        break;
                    }else { biggestNum = true; }
                }
                if (biggestNum){
                    vector[elementNum] = value;
                    elementNum++;
                }
            }
            return true;
        }
        else {
            System.out.println("Lista está cheia");
            return false;
        }
    }

    public void getList() {
        System.out.println("\nExibindo elementos da lista:");
        for (int i=0; i< elementNum; i++) {
            System.out.println(vector[i]);
        }
    }
}
