package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeeRating")
@Getter
@Setter
public class EmployeeRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeId")
	private int employeeId;

	@Id
	@Column(name = "skillId")
	private int skillId;

	@Column(name = "rating")
	private int rating;

	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "skillId", nullable = false)
	private Skill skill;

	public EmployeeRating() {
	}

	public EmployeeRating(int employeeId, int skillId, int rating) {
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "EmployeeRating [employeeId=" + employeeId + ", skillId=" + skillId + ", rating=" + rating + "]";
	}
}