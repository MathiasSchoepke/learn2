package mathiasschoepke.pojo;

import java.io.Serializable;

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
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeId")
	private int id;

	@Column(name = "seoUrl", nullable = false)
	private String seoUrl;

	@Column(name = "name", nullable = false)
	private String name;

	public Employee() {
	}

	public Employee(int id, String seoUrl, String name) {
		this.id = id;
		this.seoUrl = seoUrl;
		this.name = name;
	}
}