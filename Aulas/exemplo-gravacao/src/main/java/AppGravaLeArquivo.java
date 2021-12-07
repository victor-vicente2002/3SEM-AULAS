import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class  AppGravaLeArquivo {

    /* Método gravaLista - recebe uma lista de objetos Cachorro
     * e uma variável isCSV que indica se é arquivo CSV ou não
     * Se for arquivo CSV, grava os campos delimitados por ';'
     * Se for arquivo TXT, grava os campos delimitados por ' '
     */
    public static void gravaLista(ListaObj<Cachorro> lista, boolean isCSV, String nomeArquivo) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;

        if (isCSV) {
            nomeArquivo += ".csv";
        }
        else {
            nomeArquivo += ".txt";
        }
        try {
            arq = new FileWriter(nomeArquivo, true);  // true indica que vai fazer "append"
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);  // encerra o programa, com status de erro
        }
        try {
            for (int i=0; i< lista.getTamanho(); i++) {
                Cachorro dog = lista.getElemento(i);
                if (isCSV) {
                    saida.format("%d;%s;%s;%.2f%n",dog.getId(),	            // grava os atributos do objeto aluno
                            dog.getNome(),dog.getPorte(),dog.getPeso());	// separados por ';'
                }
                else {
                    saida.format("%d %s %s %.2f%n",dog.getId(),	// grava os atributos do objeto aluno
                            dog.getNome(),dog.getPorte(),dog.getPeso());	// separados por ' '
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    /* Método leExibeArquivo - lê e exibe os registros de um arquivo
     * Recebe true se o arquivo a ser lido é o .csv e false se for o .txt
     */
    public static void leExibeArquivo(boolean isCSV, String nomeArquivo) {
        FileReader arq= null;		// objeto FileReader - representa o arquivo a ser lido
        Scanner entrada = null;		// objeto Scanner - para ler do arquivo
        boolean deuRuim= false;		// indica se deu erro

        if (isCSV) {
            nomeArquivo += ".csv";	// nome do arquivo, se for CSV
        }
        else {
            nomeArquivo += ".txt";	// nome do arquivo, se for TXT
        }

        // Abre o arquivo para leitura
        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                // se o arquivo for CSV, usa como delimitador de campo o ';' e o fim de registro
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
            }
            else {
                // se o arquivo for TXT, usa como delimitador de campo o ' ' e o fim de registro
                entrada = new Scanner(arq);
            }
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1); // encerra o programa, com status de erro
        }

        // Lê os registros do arquivo e exibe os dados lidos na console
        try {
            // Exibe na console os títulos das colunas
            System.out.printf("%-4s%-14s%-10s%7s\n","ID","NOME","PORTE","PESO" );
            // Enquanto tem registro a ser lido
            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();			// Lê o id
                String nome = entrada.next();			// Lê o nome
                String porte = entrada.next();          // Lê o porte
                Double peso = entrada.nextDouble();		// Lê o peso
                System.out.printf("%-4d%-14s%-10s%7.2f\n",id,nome,porte,peso);	// Exibe na console em colunas
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        ListaObj<Cachorro> lista = new ListaObj<Cachorro>(5);
        lista.adiciona (new Cachorro(1, "Flash", "Pequeno", 13.0));
        lista.adiciona (new Cachorro(2, "Neguinho","Médio", 16.0));
        lista.adiciona (new Cachorro(3, "Costelinha","Pequeno", 11.5));
        lista.adiciona (new Cachorro(4, "Bolt","Grande", 34.0));
        lista.adiciona (new Cachorro(5, "Caramelo","Médio", 18.0));

        lista.exibe();
        gravaLista(lista,true,"dogs");
        leExibeArquivo(true, "dogs");
        System.out.println();

        gravaLista(lista,false,"dogs");
        leExibeArquivo(false, "dogs");
    }
}
