package respositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import model.User;

public interface RespositorioUser extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
