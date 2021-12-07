import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] carros = new String[5];
        double[] consumoCarros = new double[5];
        int indiceMaisEconomico = 0;

        System.out.println("Digite 5 modelos de carros diferentes");
        for (int i = 0; i < carros.length; i++) {
            System.out.println("Modelo do " + (i + 1) + "º carro");
            carros[i] = leitor.next();
        }

        System.out.println("Agora digite quantos km/L eles fazem");
        for (int i = 0; i < consumoCarros.length; i++) {
            System.out.println(carros[i] + ":");
            consumoCarros[i] = leitor.nextDouble();
            indiceMaisEconomico = consumoCarros[i] > consumoCarros[indiceMaisEconomico]
                    ? i : indiceMaisEconomico;
        }

        System.out.println("O " + carros[indiceMaisEconomico] + " é o modelo mais econômico");
    }
}
