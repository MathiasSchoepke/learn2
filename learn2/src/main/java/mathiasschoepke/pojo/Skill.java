package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Id
	@Column(name = "skillId")
	private int skillId;

	@Column(name = "name", nullable = false)
	private String name;

	public Skill() {
	}

	public Skill(int skillId, String name) {
		this.skillId = skillId;
		this.name = name;
	}
}