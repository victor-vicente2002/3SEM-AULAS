import java.util.Scanner;

public class ExemploVetor {

    public static void exibeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println("vet1["+i+"]= " + v[i]);
        }
    }

    public static void main(String[] args) {

        //Declaração de um objeto leitor
        Scanner leitor = new Scanner(System.in);

        //Declaração do primeiro vetor
        //Tipo: int -> tamanho: 10

        int[] vet1 = new int[10];

        //declaração do segundo vetor
        int[] vet2 = {100,200,300,400,500};

        //Declaração do terceiro vetor
        String[] vet3 = new String[4];

        //Preencher os vetor vet com valores

        for (int i = 0; i < vet1.length; i++) {
            vet1[i] = i * 10;
        }

        //Exibir elementos do vet1
        System.out.println("Exibição dos elementos do vetor:");
        exibeVetor(vet1);
        //Exibição do vetor 2
        System.out.println("\nExibição do vetor 2:");
        exibeVetor(vet2);

        //Alterando valores de vetores com valores já estipulados
        vet2[3] = vet2[2] * vet2[1];
        System.out.println("\nExibição do vetor 2 com mudança:");
        exibeVetor(vet2);

        //Solicitar que o usúario digite os valores do vetor vet3
//        for (int i = 0; i < vet3.length; i++) {
//            System.out.println("Digite o valor de vet3["+i+"]: ");
//            vet3[i] = leitor.next();
//        }

        //Exibição do vet3
//        System.out.println("\nExiição do vet3: ");
//        for (String s : vet3) {
//            System.out.print(s +"\t");
//        }

        Integer soma = 0;

        for (int i = 0; i < vet1.length; i++) {
            soma += vet1[i];
        }
        System.out.println("Soma de todos os vetores de vet1: "+ soma);

        int pairs = 0;
        for (int i =0; i < vet1.length; i++) {
            if (vet1[i]%2 == 0) {
                pairs++;
            }
        }

        System.out.println("Quantidade de números pares do vet1: " + pairs);


        String[] vet4 = {"Domingo", "Segunda", "Terça",
                "Quarta", "quinta", "Sexta", "Sabádo"};
        Boolean b = true;

        while(b) {
            System.out.println("Digite um número de 1 a 7");
            int leitura = leitor.nextInt();
            if (leitura < 1 || leitura > 7){
                System.out.println("Digite novamento um valor válido :p");
            }else{
                System.out.println("Dia da semana escolhido: " + vet4[leitura - 1]);
                b = false;
            }
        }

        int vet5[];
        Integer tamanho = 0;

        System.out.println("Digite um valor inteiro maior ou igual a três");
        tamanho = leitor.nextInt();

        while (tamanho < 3){
            System.out.println("Valor inválido. Digite novemanete!");
            tamanho = leitor.nextInt();
        }

        vet5 = new int[tamanho];

        for (int i = 0; i < vet5.length; i++) {
            System.out.println("Digite o valor de vet5["+i+"]: ");
            vet5[i] = leitor.nextInt();
        }

        System.out.println("\nExibição do vetor vet5");
        exibeVetor(vet5);


    }
}
