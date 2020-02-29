package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill")
@Getter
@Setter
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES
	@Id
	@Column(name = "skillId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	// ASSOCIATION

	// METHODS
	public Skill() {
	}

	public Skill(String name) {
		this.name = name;
	}

	public Skill(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "skill[" + id + ":" + name + "]";
	}
}