import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {

        String[] class1 = new String[10];
        String[] class2 = new String[10];

        Scanner scan = new Scanner(System.in);

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o nome de um aluno: ");
            String name = scan.next();
            System.out.println("Em qual sala este aluno está? 1 ou 2?" );
            int studentClass = scan.nextInt();

            if (studentClass == 1) {
                class1[index1] = name;
                index1++;
            }else {
                class2[index2] = name;
                index2++;
            }
        }

        int students1 = 0;
        int students2 = 0;

        System.out.println("Alunos da sala 1: ");
        for (int i=0;i<class1.length-1;i++) {
            if (class1[i] == null) {} else{
                students1++;
                System.out.println(class1[i]);
            }
        }
        System.out.println("Essa sala tem "+students1+" alunos");

        System.out.println("Alunos da sala 2: ");
        for (int i=0;i<class2.length-1;i++) {
            if (class2[i] == null) {} else {
                students2++;
                System.out.println(class2[i]+" ");
            }
        }
        System.out.println("Essa sala tem "+students2+" alunos");
    }
}
