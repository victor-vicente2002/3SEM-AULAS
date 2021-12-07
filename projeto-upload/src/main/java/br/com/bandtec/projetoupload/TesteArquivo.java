package br.com.bandtec.projetoupload;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteArquivo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("blabla.txt");
        Files.write(path, "linha loka".getBytes());
    }
}
