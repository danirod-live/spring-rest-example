package makigas.ejemplos.spring.apirest.repo;

import java.util.List;
import makigas.ejemplos.spring.apirest.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<ProfesorFullNameAndId> findAllProjectedBy();
}
