import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WriteFile2 {

    public static void writeRegister (String fileName, String register) {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            output.append(register + "\n");
            output.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }

    public static void main(String[] args) {

        String fileName = "ArquivoNotas.txt";
        String header = "";
        String body = "";
        String trailer = "";
        int dataCount = 0;
        boolean end = false;
        Scanner scan = new Scanner(System.in);

        Date dataDeHoje = new Date();
        //Aqui só formata a data para o formato que queremos
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += "00NOTA20211";
        header += formatter.format(dataDeHoje);
        header += "01";

        writeRegister(fileName, header);

        while(!end) {
            System.out.println("Escolha uma opção: \n" +
                    "1.Adicionar aluno \n" +
                    "2.Sair");
            int option = scan.nextInt();
            switch (option){
                case 1:
                    body="02";
                    System.out.println("Digite o seu RA: ");
                    body+=String.format("%-8s", scan.next());
                    System.out.println("Digite o nome do aluno:");
                    body+=String.format("%-40s", scan.next());
                    System.out.println("Digite o nome do curso: ");
                    body+=String.format("%-5s", scan.next());
                    System.out.println("Digite a disciplina: ");
                    body+=String.format("%-5s", scan.next());
                    System.out.println("Digite sua quantidade de faltas: ");
                    body+=String.format("%5d", scan.nextInt());
                    System.out.println("Digite a média do aluno: ");
                    body+=String.format("%05.2f", scan.nextDouble());

                    dataCount++;

                    writeRegister(fileName, body);
                    break;
                case 2:
                    end = true;
                    break;
                default:
                    System.out.println("Item inválido, digite novamente!");
            }

        }

        trailer += "01";
        trailer += String.format("%010d", dataCount);
        writeRegister(fileName,trailer);
    }

}

