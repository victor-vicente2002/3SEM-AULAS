import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        int[] vetorNum = new int[7];

        Scanner scan = new Scanner(System.in);
        for (int i =0;i <7;i++) {
            System.out.println("Digite um número: ");
            int num = scan.nextInt();
            vetorNum[i] = num;
        }


        System.out.println("Números do vetor:");
        for (int i =0;i <7;i++) {
            System.out.println(vetorNum[i]);
        }

        System.out.println("Números do vetor ao contrário:");
        for (int i = 6; i >= 0; i--) {
            System.out.println(vetorNum[i]);
        }

    }
}
