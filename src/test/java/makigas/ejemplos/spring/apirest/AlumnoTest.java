package makigas.ejemplos.spring.apirest;

import java.util.Locale;
import makigas.ejemplos.spring.apirest.models.Alumno;
import makigas.ejemplos.spring.apirest.repo.AlumnoRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlumnoTest
{
    @Autowired
    private AlumnoRepository alumnos;
    
    private static Faker faker;
    
    @BeforeAll
    public static void setUpClass() {
        faker = new Faker(Locale.forLanguageTag("es"));
    }
    
    @Test
    public void testChuck() {
        String facto = faker.chuckNorris().fact();
        Assertions.assertEquals(null, facto);
    }
    
    @Test
    public void testGenerate() {
        for (var i = 0; i < 10; i++) {
            Alumno a = new Alumno();
            a.setNombre(faker.name().firstName());
            a.setApellido(faker.name().lastName());
            a.setFechaNacimiento(faker.date().birthday(16, 25).toLocalDateTime().toLocalDate());
            alumnos.save(a);
        }
    }
}
