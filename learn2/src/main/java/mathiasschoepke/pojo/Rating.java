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
@Table(name = "rating")
@Getter
@Setter
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES
	@EmbeddedId
	RatingKey id;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("employee_id")
	@JoinColumn(name = "employee_id")
	Employee employee;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("skill_id")
	@JoinColumn(name = "skill_id")
	Skill skill;

	@Column(name = "rating")
	private int rating;

	// ASSOCIATION

	// METHODS
	public Rating() {
	}

	public Rating(Employee employee, Skill skill, int rating) {
		id = new RatingKey(employee.getId(), skill.getId());
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating[" + employee.getName() + ":" + skill.getName() + ":" + rating + "]";
	}
}