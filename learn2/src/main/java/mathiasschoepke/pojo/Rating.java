package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rating")
@Getter
@Setter
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES
	@Id
	@Column(name = "employee_id")
	private long employeeId;

	@Id
	@Column(name = "skill_id")
	private long skillId;

	@Column(name = "rating")
	private long rating;

	// ASSOCIATION

	// METHODS
	public Rating() {
	}

	public Rating(long employeeId, long skillId, long rating) {
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "er[" + skillId + ":" + rating + "]";
	}
}