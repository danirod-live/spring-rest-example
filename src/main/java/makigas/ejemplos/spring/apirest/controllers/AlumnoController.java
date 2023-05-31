package makigas.ejemplos.spring.apirest.controllers;

import java.util.List;
import makigas.ejemplos.spring.apirest.models.Alumno;
import makigas.ejemplos.spring.apirest.repo.AlumnoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {
    private AlumnoRepository repository;
    
    public AlumnoController(AlumnoRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/alumnos")
    public List<Alumno> list() {
        return repository.findAll();
    }    
    
    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> get(@PathVariable long id) {
        return repository.findById(id)
            .map((alu) -> ResponseEntity.ok(alu))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> insert(@RequestBody Alumno alu) {
        Alumno saved = repository.save(alu);
        if (saved.getId() != 0) {
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> update(@PathVariable long id, @RequestBody Alumno nuevo)
    {
        return repository.findById(id).map((alu) -> {
            if (nuevo.getNombre() != null) alu.setNombre(nuevo.getNombre());
            if (nuevo.getApellido() != null) alu.setApellido(nuevo.getApellido());
            if (nuevo.getFechaNacimiento() != null) alu.setFechaNacimiento(nuevo.getFechaNacimiento());
            Alumno saved = repository.save(alu);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
