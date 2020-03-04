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
}