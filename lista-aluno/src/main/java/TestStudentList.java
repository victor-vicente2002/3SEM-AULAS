import java.util.Scanner;

public class TestStudentList {
    public static void main(String[] args) {
        boolean end = false;
        int ra;
        String name;
        Double grade;
        ListObj<Student> students = new ListObj<Student>(10);
        Scanner scan = new Scanner(System.in);
        Student student1 = new Student(1234, "victor", 9.8);
        Student student2 = new Student(12, "victor v", 9.8);
        Student student3 = new Student(1, "victor m", 9.8);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        while (!end) {
            System.out.println("Escolha uma opção:\n" +
                    "1.Adicionar aluno\n" +
                    "2.Exibir a lista de alunos\n" +
                    "3.Exibir um aluno da lista\n" +
                    "4.Limpar lista\n" +
                    "5.Fim");
            int option = scan.nextInt();
            switch (option){
                case 1:
                    System.out.println("Digite o nome do aluno:");
                    name = scan.next();
                    System.out.println("Digite seu ra:");
                    ra = scan.nextInt();
                    System.out.println("Digite a nota deste aluno:");
                    grade = scan.nextDouble();
                    System.out.println("Nome: " +name+"\n" +
                            "ra: "+ra+"\n" +
                            "Nota: "+grade);
                    Student student = new Student(ra, name, grade);
                    students.add(student);
                    break;

                case 2:
                    students.getList();
                    break;

                case 3:
                    System.out.println("Digite o índice de um aluno:");
                    int index = scan.nextInt();
                    if (students.getElement(index) == null){
                        System.out.println("Índice inválido");
                    }else {
                        System.out.println(students.getElement(index));
                    }
                    System.out.println();
                    break;
                case 4:
                    students.cleanList();
                    break;
                case 5:
                    end = true;
                    break;

            }

        }
    }
}
