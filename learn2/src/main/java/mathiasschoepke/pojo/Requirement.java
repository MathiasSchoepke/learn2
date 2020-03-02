package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "requirement")
@Getter
@Setter
public class Requirement implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES
	@Id
	@Column(name = "project_id")
	private long projectId;

	@Id
	@Column(name = "skill_id")
	private long skillId;

	@Column(name = "rating")
	private long rating;

	// ASSOCIATION

	// METHODS
	public Requirement() {
	}

	public Requirement(long projectId, long skillId, long rating) {
		this.projectId = projectId;
		this.skillId = skillId;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "pr[" + skillId + ":" + rating + "]";
	}
}