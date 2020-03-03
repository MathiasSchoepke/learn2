package mathiasschoepke.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job {

	// ATTRIBUTES
	@EmbeddedId
	JobKey id;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("employee_id")
	@JoinColumn(name = "employee_id")
	Employee employee;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("project_id")
	@JoinColumn(name = "project_id")
	Project project;

	// @Column(name = "role_id")
	// private long roleId;

	// ASSOCIATION
	// , insertable = false
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	Role role;

	// METHODS
	public Job() {
	}

	public Job(Employee employee, Project project, Role role) {
		id = new JobKey(employee.getId(), project.getId());
		this.role = role;
	}

	@Override
	public String toString() {
		return "Job[" + employee.getName() + ":" + project.getName() + ":" + role.getName() + "]";
	}
}
