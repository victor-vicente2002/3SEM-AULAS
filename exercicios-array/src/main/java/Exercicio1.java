import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] numeros = new int[7];

        System.out.println("Vamos preecher um vetor de 7 números");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número");
            numeros[i] = leitor.nextInt();
        }

        System.out.println("Exibindo na ordem de preenchimento");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + "|\t");
        }

        System.out.println("\nExibindo na ordem inversa");
        for (int i = numeros.length; i > 0; i--) {
            System.out.print(numeros[i - 1] + "|\t");
        }
    }
}
