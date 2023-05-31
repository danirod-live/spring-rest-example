package makigas.ejemplos.spring.apirest.repo;

import makigas.ejemplos.spring.apirest.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
}
