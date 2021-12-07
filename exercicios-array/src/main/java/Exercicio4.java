import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] numeros = new int[10];
        int numeroQualquer;
        int contador = 0;

        System.out.println("Vamos preencher um vetor com 10 números");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º números");
            numeros[i] = leitor.nextInt();
        }

        System.out.println("\nDigite um número qualquer");
        numeroQualquer = leitor.nextInt();
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroQualquer) {
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("O número " + numeroQualquer + " não ocorre nenhuma vez");
        } else {
            System.out.println(String.format("O número %d ocorre %d vez(es)",
                    numeroQualquer, contador));
        }
    }
}
