package makigas.ejemplos.spring.apirest.repo;

import java.util.Optional;
import makigas.ejemplos.spring.apirest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{    
    public Optional<Usuario> findByUsername(String username);   
}
