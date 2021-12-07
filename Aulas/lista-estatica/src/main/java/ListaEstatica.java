public class ListaEstatica {

    int[] vector;
    int numberElemt;

    public ListaEstatica(int index) {
        vector = new int[index];
        numberElemt = 0;
    }

    public boolean add(int number) {
        if (this.vector.length > this.numberElemt) {
            vector[numberElemt] = number;
            numberElemt++;
            return true;
        }else { return false; }
    }

    public void getVector() {
        System.out.println("Todos os números da sua lista:");
        for (int i = 0; i < numberElemt; i++) {
            System.out.println(vector[i]);
        }
        System.out.println("**************************");
    }

    public int search (int search) {
        int positionValue = 0;
        for (int i = 0; i < numberElemt; i++) {
            if (search == vector[i]) {
                positionValue = i;
                break;
            }
            else {positionValue = -1;}
        }
        return positionValue;
    }

    public boolean deleteByIndex(int index) {
        if (index < numberElemt) {
            int count = index;
            for (int i = 0; i < numberElemt-(index+1); i++) {
                vector[count] = vector[++count];
            }
        numberElemt--;
        return true;
        }
        else { return false; }
    }

//    public boolean deleteByElemt(int number) {
//        int index = 0;
//        boolean message = false;
//        for (int i=0; i<numberElemt; i++) {
//            if (number == vector[i]) {
//                index = i;
//                message = true;
//            }
//        }
//        this.deleteByIndex(index);
//        return message;
//    }

    public boolean deleteByElemt(int number) {
        return this.deleteByIndex(this.search(number));
    }

    //Métodos exe
    //letra a
    public boolean replaces(int oldValue, int newValue) {
        int findItem = search(oldValue);
        if (!(findItem < 0)) {
            vector[findItem] = newValue;
            return true;
        }else {
            System.out.println("O valor "+oldValue+" não existe nessa lista");
            return false;
        }
    }
    //letra b
    public int countOccurrences (int value) {
        int occurrences = 0;
        for (int i = 0; i < numberElemt; i++) {
            if (vector[i] == value) {
                occurrences++;
            }
        }
        return occurrences;
    }
    //letra c
    public boolean addInFirstIndex(int value) {
        if (vector.length > numberElemt) {
            for (int i = numberElemt -1; i >= 0; i--) {
                vector[i+1] = vector[i];
            }
            numberElemt++;
            vector[0] = value;
            return true;
        }else { return false; }
    }
}
