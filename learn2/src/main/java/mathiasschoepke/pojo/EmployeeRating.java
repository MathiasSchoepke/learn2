package mathiasschoepke.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeeRating")
@Getter
@Setter
public class EmployeeRating {

	@Column(name = "employeeId")
	private int employeeId;

	@Column(name = "skillId")
	private int skillId;

	@Column(name = "rating")
	private int rating;

	public EmployeeRating() {
	}

	public EmployeeRating(int employeeId, int skillId, int rating) {
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.rating = rating;
	}
}