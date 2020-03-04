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
public class RatingKey implements Serializable {

	@Column(name = "employee_id")
	Long employeeId;

	@Column(name = "skill_id")
	Long skillId;

	public RatingKey() {
	}

	public RatingKey(long employeeId, long skillId) {
		this.employeeId = employeeId;
		this.skillId = skillId;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((employeeId == null) ? 0 :
	// employeeId.hashCode());
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
	// RatingKey other = (RatingKey) obj;
	// if (employeeId == null) {
	// if (other.employeeId != null)
	// return false;
	// } else if (!employeeId.equals(other.employeeId))
	// return false;
	// if (skillId == null) {
	// if (other.skillId != null)
	// return false;
	// } else if (!skillId.equals(other.skillId))
	// return false;
	// return true;
	// }
}