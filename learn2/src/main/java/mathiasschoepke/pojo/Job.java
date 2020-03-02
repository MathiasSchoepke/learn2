package mathiasschoepke.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Job {

	// ATTRIBUTES
	@EmbeddedId
	JobKey id;

	@ManyToOne
	@MapsId("employee_id")
	@JoinColumn(name = "employee_id")
	Employee employee;

	@ManyToOne
	@MapsId("project_id")
	@JoinColumn(name = "project_id")
	Project project;

	// @Column(name = "role_id")
	// private long roleId;

	// ASSOCIATION
	@ManyToOne()
	@JoinColumn(name = "role_id", insertable = false)
	Role role;

	// METHODS
	public Job() {
	}

	public Job(long employeeId, long projectId, Role role) {
		id = new JobKey(employeeId,projectId);
		this.role = role;
	}

	@Override
	public String toString() {
		return "Job[" + employee.getName() + ":" + project.getName() + ":" + role.getName() + "]";
	}
}
