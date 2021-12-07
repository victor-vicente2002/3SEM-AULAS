import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] nomes = new String[10];
        String nomeQualquer;
        Integer contador = 0;

        System.out.println("Vamos preencher um vetor com 10 nomes");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º nome");
            nomes[i] = leitor.next();
        }

        System.out.println("\nDigite um nome qualquer");
        nomeQualquer = leitor.next();
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals(nomeQualquer)) {
                System.out.println("Nome encontrado no índice " + i);
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("Nome não encontrado");
        }
    }
}
