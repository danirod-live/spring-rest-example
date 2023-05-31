package makigas.ejemplos.spring.apirest.repo;

import makigas.ejemplos.spring.apirest.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    
}
