import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestMovie {

    public static void main(String[] args) {
        boolean end = false;
        Integer idMovie = 0;
        String name;
        Double grade;
        String genre;
        Integer age;
        ListObj<Movie> movieList = new ListObj<Movie>(10);
        Scanner scan = new Scanner(System.in);

        while (!end) {
            System.out.println("Escolha uma opção:\n" +
                    "1.Adicionar um filme\n" +
                    "2.Exibir a lista de filmes\n" +
                    "3.Gravar a lista em um arquivo csv\n" +
                    "4.Ler e exibir um arquivo csv\n" +
                    "5.Gravar em outro arquivo csv apenas filmes que estão na lista, mas de um determinado gênero\n" +
                    "6.Fim");
            int option = scan.nextInt();
            switch (option){
                case 1:
                    System.out.println("Digite o nome do filme:");
                    name = scan.next();
                    System.out.println("Digite a nota do filme:");
                    grade = scan.nextDouble();
                    System.out.println("Digite o gênero do filme:");
                    genre = scan.next();
                    System.out.println("Digite a faixa etária para assistir:");
                    age = scan.nextInt();
                    System.out.println("Nome: " +name+
                            "\nNota: "+grade+
                            "\nGênero: "+genre+
                            "\nIdade: "+age);
                    movieList.add(new Movie(idMovie++, name, grade, genre, age));
                    break;

                case 2:
                    movieList.getList();
                    break;

                case 3:
                    if (!movieList.isEmpty()) {
                        System.out.println("Digite um nome para o arquivo que irá criar: ");
                        String fileName = scan.next();
                        listWriter(movieList, true, fileName);
                        movieList.cleanList();
                    }else {
                        System.out.println("A lista está vazia, não há nada para gravar");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do arquivo que deseja ver: ");
                    String filename = scan.next();
                    readShowFile(true, filename);
                    break;
                case 5:
                    if (!movieList.isEmpty()) {
                        System.out.println("Digite o gênero que deseja gravar: ");
                        String movieGenre = scan.next();
                        System.out.println("Digite o nome do arquivo que irá criar: ");
                        String fileName = scan.next();

                        ListObj<Movie> specificGenreMovie = new ListObj<Movie>(10);
                        for (int i = 0; i < movieList.getSize(); i++) {
                            Movie actualMovie = movieList.getElement(i);
                            if (actualMovie.getGenre().equals(movieGenre)){
                                specificGenreMovie.add(actualMovie);
                            }
                        }

                        if (specificGenreMovie.isEmpty()){
                            System.out.println("Não tem nenhum filme desse gênero na lista");
                        }else {
                            listWriter(specificGenreMovie, true, fileName);
                        }
                    }else {
                        System.out.println("A lista está vazia, não há nada para gravar");
                    }
                    break;
                case 6:
                    end = true;
                    break;

            }

        }

    }

    public static void listWriter(ListObj<Movie> list, boolean isCSV, String fileName) {
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
                Movie movie = list.getElement(i);

                if (isCSV) {
                    output.format("%d;%s;%.2f;%s;%d%n",movie.getIdMovie(), movie.getName(),
                            movie.getGrade(),movie.getGenre(),movie.getAge());
                }
                else {
                    output.format("%d %s %.2f %s %d%n",movie.getIdMovie(), movie.getName(),
                            movie.getGrade(),movie.getGenre(),movie.getAge());
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
            fileName += ".csv";
        }
        else {
            fileName += ".txt";
        }

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

            System.out.printf("%-5s%-30s%-7s%-10s%6s\n","ID","NOME","NOTA", "GÊNERO", "IDADE");

            while (input.hasNext()) {
                Integer id = input.nextInt();
                String name = input.next();
                Double grade = input.nextDouble();
                String genre = input.next();
                Integer age = input.nextInt();
                System.out.printf("%-5d%-30s%-7.2f%-10s%6d\n",id,name,grade,genre,age);
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

}
