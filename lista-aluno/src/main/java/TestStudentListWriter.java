import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestStudentListWriter {

    public static void listWriter(ListObj<Student> list, boolean isCSV, String fileName) {
        FileWriter fileWriter = null;
        Formatter output = null;
        boolean error = false;

        if (isCSV) { fileName += ".csv"; }
        else { fileName += ".txt"; }

        try {
            fileWriter = new FileWriter(fileName, true);
            output = new Formatter(fileWriter);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }

        try {
            for (int i=0; i< list.getSize(); i++) {
                Student student = list.getElement(i);

                if (isCSV) {
                    output.format("%d;%s;%.2f%n",student.getRa(),
                            student.getName(),student.getGrade());
                }
                else {
                    output.format("%d %s %.2f%n",student.getRa(),
                            student.getName(),student.getGrade());
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            error = true;
        }
        finally {
            output.close();
            try {
                fileWriter.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                error = true;
            }
            if (error) {
                System.exit(1);
            }
        }
    }

    public static void readShowFile(boolean isCSV, String fileName) {
        FileReader fileReader= null;
        Scanner input = null;
        boolean error = false;

        if (isCSV) {
            fileName += ".csv";	// nome do arquivo, se for CSV
        }
        else {
            fileName += ".txt";	// nome do arquivo, se for TXT
        }

        // Abre o arquivo para leitura
        try {
            fileReader = new FileReader(fileName);
            if (isCSV) {
                input = new Scanner(fileReader).useDelimiter(";|\\r\\n");
            }
            else {
                input = new Scanner(fileReader);
            }
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {

            System.out.printf("%-9s%-20s%7s\n","RA","NOME","NOTA");

            while (input.hasNext()) {
                Integer ra = input.nextInt();
                String name = input.next();
                Double grade = input.nextDouble();
                System.out.printf("%-9d%-20s%7.2f\n",ra,name,grade);
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            error = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            error = true;
        }
        finally {
            input.close();
            try {
                fileReader.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                error = true;
            }
            if (error) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        ListObj<Student> studentsList = new ListObj<Student>(5);
        studentsList.add(new Student(1234, "victor", 5.8));
        studentsList.add(new Student(12, "victorV", 2.5)); //Não pode ter espaço se não dá pau
        studentsList.add(new Student(1, "victorM", 4.1));

        studentsList.getList();
        listWriter(studentsList,true,"estudantes");
        readShowFile(true, "estudantes");
        System.out.println();

        listWriter(studentsList,false,"estudantes");
        readShowFile(false, "estudantes");
    }

}
