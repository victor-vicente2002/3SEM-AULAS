import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {

        int[] vetorNum = new int[10];

        Scanner scan = new Scanner(System.in);
        for (int i =0;i <10;i++) {
            System.out.println("Digite um número: ");
            int num = scan.nextInt();
            vetorNum[i] = num;
        }

        System.out.println("Digite um número para pesquisa: ");
        int search = scan.nextInt();
        int frequency = 0;

        for (int i =0;i <10;i++) {
            if (search == vetorNum[i]) {
                frequency++;
            }
        }

        if (frequency == 0) {
            System.out.println("O múmero "+search+" não ocorre nenhuma vez!");
        }else {
            System.out.println("O número "+search+" ocorre "+frequency+" vezes");
        }
    }
}
