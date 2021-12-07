package br.com.bandtec.projetojpa03.controller;

import br.com.bandtec.projetojpa03.dominio.Student;
import br.com.bandtec.projetojpa03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping
    public ResponseEntity getStudents() {
        List<Student> students = repository.findAll();
        if (!students.isEmpty()) {
            return ResponseEntity.status(200).body(students);
        } else {
            return ResponseEntity.status(204).build();
        }
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student) {
        repository.save(student);
        return ResponseEntity.status(201).build();
    }
}
