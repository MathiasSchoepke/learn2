package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
	@EmbeddedId
	RequirementKey id;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("project_id")
	@JoinColumn(name = "project_id")
	Project project;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("skill_id")
	@JoinColumn(name = "skill_id")
	Skill skill;

	@Column(name = "rating")
	private int rating;

	// ASSOCIATION

	// METHODS
	public Requirement() {
	}

	public Requirement(Project project, Skill skill, int rating) {
		id = new RequirementKey(project.getId(), skill.getId());
		this.rating = rating;
	}

	// @Override
	// public String toString() {
	// return "pr[" + skillId + ":" + rating + "]";
	// }
}