package mathiasschoepke.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "skill")
	private List<EmployeeRating> ratings;

	public Skill() {
	}

	public Skill(int skillId, String name) {
		this.skillId = skillId;
		this.name = name;
	}
}