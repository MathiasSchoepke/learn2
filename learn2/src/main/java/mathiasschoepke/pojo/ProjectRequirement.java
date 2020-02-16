package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projectRequirement")
@Getter
@Setter
public class ProjectRequirement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "projectId")
	private int projectId;

	@Id
	@Column(name = "skillId")
	private int skillId;

	@Column(name = "rating")
	private int rating;

	public ProjectRequirement() {
	}

	public ProjectRequirement(int projectId, int skillId, int rating) {
		this.projectId = projectId;
		this.skillId = skillId;
		this.rating = rating;
	}
}