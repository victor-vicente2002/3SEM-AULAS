package br.com.bandtec.projetoupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/arquivos")
public class ArquivosController {

    @Autowired
    private AnexoRepository repository;

    @PostMapping
    public ResponseEntity criarArquivo(@RequestParam MultipartFile arquivo) throws IOException {
        System.out.println("Recebendo um arquivo de nome: "+arquivo.getOriginalFilename());
        System.out.println("Recebendo um arquivo de tipo: "+arquivo.getContentType());

        byte[] conteudo = arquivo.getBytes();
        Path path = Paths.get(arquivo.getOriginalFilename());
        Files.write(path, conteudo);

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/anexo")
    public ResponseEntity criarAnexo(@RequestParam MultipartFile arquivo) throws IOException {

        Anexo novoAnexo = new Anexo();
        novoAnexo.setNomeArquivo(arquivo.getOriginalFilename());
        novoAnexo.setConteudoArquivo(arquivo.getBytes());

        repository.save(novoAnexo);

        return ResponseEntity.status(201).build();
    }

}
