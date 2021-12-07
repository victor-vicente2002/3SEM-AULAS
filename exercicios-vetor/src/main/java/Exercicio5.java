import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {

        String[] carNames = new String[5];
        Double[] consuption = new Double[5];

        Scanner scan = new Scanner(System.in);
        for (int i =0;i < 5;i++) {
            System.out.println("Digite o nome de um carro : ");
            String name = scan.next();
            carNames[i] = name;
        }

        for (int i =0;i < 5;i++) {
            System.out.println("Digite o consumo do "+carNames[i]+": ");
            Double spents = scan.nextDouble();
            consuption[i] = spents;
        }

        Double lessExpensive = consuption[0];
        int index = 0;

        for (int i =0;i < 5;i++) {
            if (consuption[i] > lessExpensive) {
                lessExpensive = consuption[i];
                index = i;
            }
        }

        System.out.println("O carro mais economico é o "+carNames[index]);



    }
}
