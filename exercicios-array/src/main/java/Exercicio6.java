import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] diasMeses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dia = 0;
        int mes = 0;
        int diaDoAno = 0;

        System.out.println("Digite um dia qualquer(1 a 31)");
        dia = leitor.nextInt();

        System.out.println("Digite um mes qualquer(1 a 12)");
        mes = leitor.nextInt();

        for (int i = 0; i < mes - 1; i++) {
            diaDoAno += diasMeses[i];
        }

        diaDoAno += dia;

        System.out.println(String.format("O dia %d/%d corresponde ao dia %d do ano",
                dia, mes, diaDoAno));
    }
}
