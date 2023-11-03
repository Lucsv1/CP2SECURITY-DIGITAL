package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@ManyToMany
	private GrantedAuthority[] roles;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GrantedAuthority[] getRoles() {
		return roles;
	}

	public void setRoles(GrantedAuthority[] roles) {
		this.roles = roles;
	}

	
	
	
	
	

}
