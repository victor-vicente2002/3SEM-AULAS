import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] numeros = new int[10];
        int soma = 0;
        double media = 0;

        System.out.println("Vamos preecher um vetor de 10 números");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número");
            numeros[i] = leitor.nextInt();
            soma += numeros[i];
        }

        media = soma / numeros.length;
        System.out.println("A média dos números é " + media);
        System.out.println("Números acima da média:");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > media) {
                System.out.print(numeros[i] + "|\t");
            }
        }
    }
}
