package mathiasschoepke.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	// ATTRIBUTES
	@Id
	@Column(name = "employeeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "seoUrl", nullable = false)
	private String seoUrl;

	@Column(name = "name", nullable = false)
	private String name;

	// ASSOCIATION

	// METHODS
	public Employee() {
	}

	public Employee(String seoUrl, String name) {
		this.seoUrl = seoUrl;
		this.name = name;
	}

	public Employee(int id, String seoUrl, String name) {
		this.id = id;
		this.seoUrl = seoUrl;
		this.name = name;
	}

	@Override
	public String toString() {
		return "employee[" + id + ":" + name + "]";
	}
}