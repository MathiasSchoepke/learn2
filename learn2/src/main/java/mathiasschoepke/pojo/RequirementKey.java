package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class RequirementKey implements Serializable {

	@Column(name = "project_id")
	Long projectId;

	@Column(name = "skill_id")
	Long skillId;

	public RequirementKey() {
	}

	public RequirementKey(long employeeId, long skillId) {
		this.projectId = employeeId;
		this.skillId = skillId;
	}
}