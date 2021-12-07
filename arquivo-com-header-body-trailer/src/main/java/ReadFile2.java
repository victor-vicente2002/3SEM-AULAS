import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile2 {
    public static void leArquivo(String nomeArq) {
        BufferedReader input = null;
        BufferedReader input2 = null;
        String register;
        String lastLine;
        String registerId = null;
        int dataCount = 0;
        int registerNumber = 0;

        // Abre o arquivo
        try {
            input = new BufferedReader(new FileReader(nomeArq));
            input2 = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            lastLine = input2.readLine();
            while (lastLine != null){
                registerId = lastLine.substring(0, 2);
                if (registerId.equals("01")){
                    registerNumber = Integer.parseInt(lastLine.substring(2,12));
                }
                lastLine = input2.readLine();
            }
        }catch (IOException e) {
                System.err.printf("Erro ao ler arquivo: %s.\n", e.getMessage());
        }
        ListObj listStudent = new ListObj(registerNumber);

        // Lê os registros do arquivo
        try {
            // Lê um register
            register = input.readLine();

            while (register != null) {
                // Obtém o tipo do register
                registerId = register.substring(0, 2); // obtém os 2 primeiros caracteres do register

                if (registerId.equals("00")) {
                    System.out.println("Header");
                    System.out.println("Tipo de arquivo: " + register.substring(2, 6));
                    int periodoLetivo= Integer.parseInt(register.substring(6,11));
                    System.out.println("Período letivo: " + periodoLetivo);
                    System.out.println("Data/hora de geração do arquivo: " + register.substring(11,30));
                    System.out.println("Versão do layout: " + register.substring(30,32));
                }
                else if (registerId.equals("01")) {
                    System.out.println("\nTrailer");
                    int qtdRegistro = Integer.parseInt(register.substring(2,12));
                    if (qtdRegistro == dataCount) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    }
                    else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }
                }
                else if (registerId.equals("02")) {
                    String ra = register.substring(2,10);
                    String name = register.substring(10, 50).trim().replaceAll("\\s+", " ");;
                    String course = register.substring(50,55).trim().replaceAll("\\s+", " ");;
                    String subject = register.substring(55,60).trim().replaceAll("\\s+", " ");;
                    String faults = register.substring(60,65).trim().replaceAll("\\s+", " ");;
                    String grade = register.substring(65,70).trim().replaceAll(",", ".");;

                    listStudent.add(new Student(name, ra, course, subject, Integer.parseInt(faults)
                            , Double.parseDouble(grade)));
                    dataCount++;
                }
                else {
                    System.out.println("Tipo de register inválido");
                }

                // lê o próximo register
                register = input.readLine();
            }

            input.close();
        } catch (IOException e) {
            System.err.printf("Erro ao ler arquivo: %s.\n", e.getMessage());
        }

        listStudent.getList();

    }

    public static void main(String[] args) {
        String nomeArq = "ArquivoNotas.txt";
        leArquivo(nomeArq);
    }
}
