package mathiasschoepke.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeeHasProject")
@Getter
@Setter
public class EmployeeHasProject {

	@Column(name = "employeeId")
	private int employeeId;

	@Column(name = "projectId")
	private int projectId;

	@Column(name = "skillId")
	private int skillId;

	public EmployeeHasProject() {
	}

	public EmployeeHasProject(int employeeId, int projectId, int skillId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.skillId = skillId;
	}
}