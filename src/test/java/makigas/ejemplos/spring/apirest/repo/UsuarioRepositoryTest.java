package makigas.ejemplos.spring.apirest.repo;

import jakarta.transaction.Transactional;
import java.util.Optional;
import makigas.ejemplos.spring.apirest.models.Usuario;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UsuarioRepositoryTest {
    
    @Autowired
    UsuarioRepository repo;
    
    @BeforeEach
    public void setUp() {
        Usuario u = new Usuario();
        u.setUsername("dani");
        u.setPassword("dani");
        repo.save(u);
    }
    
    @Test
    public void testUserExists() {
        Optional<Usuario> u = repo.findByUsername("dani");
        assertTrue(u.isPresent());
        assertFalse(u.isEmpty());
    }
    
    @Test
    public void testUserDoesNotExist() {
        Optional<Usuario> u = repo.findByUsername("asdfasdf");
        assertTrue(u.isEmpty());
        assertFalse(u.isPresent());
    }
    
}
