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

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((projectId == null) ? 0 :
	// projectId.hashCode());
	// result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// RequirementKey other = (RequirementKey) obj;
	// if (projectId == null) {
	// if (other.projectId != null)
	// return false;
	// } else if (!projectId.equals(other.projectId))
	// return false;
	// if (skillId == null) {
	// if (other.skillId != null)
	// return false;
	// } else if (!skillId.equals(other.skillId))
	// return false;
	// return true;
	// }
}