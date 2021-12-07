public class ListObj <T>{

    private T[] vector;
    private int vectorNum;


    public ListObj(int size) {
        this.vector = (T[]) new Object[size];
        this.vectorNum = 0;
    }

    //Método para adicionar a lista
    public boolean add(T object) {
        if (vectorNum >= vector.length) {          // Verifica se a lista está cheia
            System.out.println("Lista está cheia");
            return false;
        }
        else {
            vector[vectorNum++] = object;           // Se não está, coloca o valor no vetor,
            // na posição nroElem e incrementa nroElem
            return true;
        }
    }

    // Método exibe - exibe os elementos da lista
    public void getList() {
        System.out.println("\nExibindo elementos da lista:");
        for (int i=0; i< vectorNum; i++) {        // Percorre enquanto i < nroElem
            System.out.print(vector[i] + "\t");
        }
        System.out.println();
    }

    // Método busca - recebe um valor e verifica se esse valor está na lista
    // Se estiver, retorna o índice onde ele se encontra, senão retorna -1
    public int getValue(T object) {
        for (int i=0; i < vectorNum; i++) {
            if (vector[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // Método removePeloIndice - recebe o índice do valor a ser removido
    public boolean removeByIndex(int index) {
        if (index < 0 || index >= vectorNum) {  // se índice for inválido
            return false;                       // retorna false
        }
        else {
            // Percorre o vetor a partir do indice recebido, sobrescrevendo
            // os valores
            for (int i = index; i < vectorNum - 1; i++) {
                vector[i] = vector[i+1];
            }
            /* outra forma de fazer
            for (int i=index+1; i < vectorNum; i++) {
                vector[i-1] = vector[i];
            } */
            vectorNum --;      // decrementa nroElem
            return true;    // retorna true
        }
    }

    //Remove elemento pelo seu "nome"
    public boolean removeElement(T object) {
        return this.removeByIndex(this.getValue(object));
    }

    //Pega o tamanho da lista
    public int getSize() {
        return vectorNum;
    }

    //Pega um elemento
    public T getElement(int index) {
        return vector[index];
    }

    //Limpa a lista
    public void cleanList() {
        vectorNum = 0;
        System.out.println("Lista limpa com sucesso!");
    }


}
