import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {

        int[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o númeiro de um mês(1 ao 12): ");
        int month = scan.nextInt();
        System.out.println("Digite um dia desse mês: ");
        int day = scan.nextInt();

        int base = 0;
        for (int i=0; i< month - 1; i++) {
            base += daysInMonths[i];
        }
        int dayYear = base + day;

        System.out.println("O dia "+day+"/"+month+" corresponde ao dia "+dayYear+" do ano");
    }
}
