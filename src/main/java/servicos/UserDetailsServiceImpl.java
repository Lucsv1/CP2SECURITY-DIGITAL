package servicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import model.User;
import respositorios.RespositorioUser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
    private final PasswordEncoder passwordEncoder;
    private RespositorioUser repositorioUser;
    
    
    
    @Autowired
    public UserDetailsServiceImpl(RespositorioUser userRepository, PasswordEncoder passwordEncoder) {
        this.repositorioUser = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositorioUser.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
