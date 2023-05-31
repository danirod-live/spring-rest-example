package makigas.ejemplos.spring.apirest.repo;

import makigas.ejemplos.spring.apirest.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    
}
