import java.util.Scanner;

public class Exercicio7 {

    public static int verificarInidce(int[] vetor, int posicao, int valor) {
        for (int i = 0; i < posicao; i++) {
            if (vetor[i] > valor) {
                return i;
            }
        }
        return posicao;
    }

    public static void ordenarVetor(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int respectivoIndice = verificarInidce(vetor, i, vetor[i]);
            int valorIndiceAtual = vetor[i];

            for (int j = i; j > respectivoIndice; j--) {
                vetor[j] = vetor[j - 1];
            }

            vetor[respectivoIndice] = valorIndiceAtual;
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] vetor1 = new int[5];
        int[] vetor2 = new int[5];
        int[] vetor3 = new int[10];
        int contadorVetor1 = 0;
        int contadorVetor2 = 0;

        System.out.println("Vamos preecher o 1º vetor com 5 números");
        for (int i = 0; i < vetor1.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número");
            vetor1[i] = leitor.nextInt();
        }

        System.out.println("Vamos preecher o 2º vetor com 5 números");
        for (int i = 0; i < vetor2.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número");
            vetor2[i] = leitor.nextInt();
        }

        ordenarVetor(vetor1);
        ordenarVetor(vetor2);

        System.out.println("\nVetor 1");
        for (int i = 0; i < vetor1.length; i++) {
            System.out.print(vetor1[i] + "\t");
        }

        System.out.println("\nVetor 2");
        for (int i = 0; i < vetor2.length; i++) {
            System.out.print(vetor2[i] + "\t");
        }

        System.out.println("\nVetor 3");
        for (int i = 0; i < vetor3.length; i++) {
            if (contadorVetor1 == 5) {
                vetor3[i] = vetor2[contadorVetor2];
                contadorVetor2++;
            } else if (contadorVetor2 == 5) {
                vetor3[i] = vetor1[contadorVetor1];
                contadorVetor1++;
            } else if (vetor1[contadorVetor1] < vetor2[contadorVetor2]) {
                vetor3[i] = vetor1[contadorVetor1];
                contadorVetor1++;
            } else {
                vetor3[i] = vetor2[contadorVetor2];
                contadorVetor2++;
            }
            System.out.print(vetor3[i] + "\t");
        }
    }
}
