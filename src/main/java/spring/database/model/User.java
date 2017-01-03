package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	private Integer id;
	private String username;
	private String password;
	private String email="";
	private boolean enabled;
	private String role;
	//private Set<UserRole> userRole = new HashSet<UserRole>(1);

	public User() {
	}

	public User(String username, String password, /*String email,*/
				boolean enabled) {
		this.username = username;
		this.password = password;
        /*this.email = email;*/
		this.enabled = enabled;
	}

	public User(String username, String password, /*String email,*/
				boolean enabled /*Set<UserRole> userRole*/, String role) {
		this.username = username;
		this.password = password;
        /*this.email = email;*/
		this.enabled = enabled;
		this.role = role;
		//this.userRole = userRole;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "USERNAME", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ENABLED", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		System.out.println("in getUserRole");
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}*/

	@Column(name = "ROLE", nullable = false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", enabled='" + enabled + '\'' +
				'}';
	}

}
