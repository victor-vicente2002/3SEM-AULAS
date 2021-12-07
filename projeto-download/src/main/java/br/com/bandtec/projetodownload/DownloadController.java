package br.com.bandtec.projetodownload;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/downloads")
public class DownloadController {

    @GetMapping("/one")
    public ResponseEntity getOne() {
        return ResponseEntity.status(200).body("{'nome':'Zé Buduia'}");
    }

    @GetMapping(value = "/crazy-file", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity getCrazy() {
        return ResponseEntity.ok("Só que não!");
    }

    @GetMapping(value = "crazy-zip",produces = "application/zip")
    public ResponseEntity getZip() {

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", "attachment; filename=crazy.zip");
        headers.add("Lady-Gaga", "Ualalá");

        return ResponseEntity.status(200).headers(headers).body("Conteúdo fake zip");
    }

    @GetMapping(value = "/pdf", produces = "application/pdf")
    public ResponseEntity getPdf() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename=sonhos_atualizados.pdf");

        byte[] file = Files.readAllBytes( Paths.get("sonhos_atualizados.pdf") );

        ResponseEntity<byte[]> responseEntity = new ResponseEntity(file, headers, 200);
        return responseEntity;
    }

}
