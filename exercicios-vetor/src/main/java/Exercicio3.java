import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {

        int[] vetorNum = new int[10];

        Scanner scan = new Scanner(System.in);
        for (int i =0;i <10;i++) {
            System.out.println("Digite um número: ");
            int num = scan.nextInt();
            vetorNum[i] = num;
        }

        Double sum = 0.0;
        int qtdNum = 0;

        for (int i =0;i <10;i++) {
            sum += vetorNum[i];
            qtdNum ++;
        }

        Double media = sum/qtdNum;

        System.out.println("Média dos números do vetor: " + media);

        System.out.println("Números acima da média");
        for (int i =0;i <10;i++) {
            if (vetorNum[i] > sum/qtdNum) {
                System.out.print(vetorNum[i]+ " ");
            }
        }

    }
}
