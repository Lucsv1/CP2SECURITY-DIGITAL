package servicos;

import org.springframework.security.core.userdetails.User;


public class CustomUserDetails extends User {
	
	private User user;
	
	 public CustomUserDetails(User user) {
	        super(user.getUsername(), user.getPassword(), user.getAuthorities());
	        this.user = user;
	    }

}
