package keyvalue.model;

public class User {
	private Integer id;
	private String email, password, name, rol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(Integer id, String email, String password) {
		setId(id);
		setEmail(email);
		setPassword(password);
	}

	public User(Integer id, String email, String password, String name) {
		setId(id);
		setEmail(email);
		setPassword(password);
		setName(name);

	}

	public User(Integer id, String email, String password, String name, String rol) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", rol=" + rol
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
