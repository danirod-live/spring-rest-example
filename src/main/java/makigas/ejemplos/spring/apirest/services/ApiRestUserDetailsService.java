package makigas.ejemplos.spring.apirest.services;

import makigas.ejemplos.spring.apirest.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ApiRestUserDetailsService implements UserDetailsService {

    private UsuarioRepository repo;
    
    @Autowired
    public ApiRestUserDetailsService(UsuarioRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optionUser = repo.findByUsername(username);
        if (optionUser.isEmpty()) {
            throw new UsernameNotFoundException("No encuentro este user");
        }
        return new ApiRestUserDetails(optionUser.get());
    }
    
}
