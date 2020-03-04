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
public class JobKey implements Serializable {

	@Column(name = "employee_id")
	Long employeeId;

	@Column(name = "project_id")
	Long projectId;

	public JobKey() {
	}

	public JobKey(Long employeeId, Long projectId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
	}
}