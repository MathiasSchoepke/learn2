package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeeHasProject")
@Getter
@Setter
public class EmployeeHasProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeId")
	private int employeeId;

	@Id
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