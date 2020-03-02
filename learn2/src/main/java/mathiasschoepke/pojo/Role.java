package mathiasschoepke.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	// ASSOCIATION
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<Job> roles;

	// METHODS
	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "role[" + id + ":" + name + "]";
	}
}