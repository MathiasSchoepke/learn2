package mathiasschoepke.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

	@Id
	@Column(name = "employeeId")
	private int employeeId;

	@Column(name = "seoUrl", nullable = false)
	private String seoUrl;

	@Column(name = "name", nullable = false)
	private String name;

	public Employee() {
	}

	public Employee(int employeeId, String seoUrl, String name) {
		this.employeeId = employeeId;
		this.seoUrl = seoUrl;
		this.name = name;
	}
}