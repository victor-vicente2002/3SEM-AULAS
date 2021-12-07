import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        String[] arrayName = new String[5];

        Scanner scan = new Scanner(System.in);
        for (int i =0;i <5;i++) {
            System.out.println("Adicione um nome: ");
            arrayName[i] = scan.next();
        }

        System.out.println("Digite um nome para pesquisar");
        String searchName = scan.next();

        Boolean search = false;
        int index = 0;

        for (int i=0; i<5;i++) {
            if (searchName.equals(arrayName[i])) {
                search = true;
                index = i;
                break;
            }
        }

        if (search) {
            System.out.println("Nome encontrado no índice " + index);
        }else {
            System.out.println("Nome NÃO encontrado!");
        }

    }
}
