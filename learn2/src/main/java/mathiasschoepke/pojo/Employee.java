package mathiasschoepke.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "seo_url", nullable = false)
	private String seoUrl;

	@Column(name = "name", nullable = false)
	private String name;

	// ASSOCIATION
	@OneToMany(mappedBy = "employee")
	private List<Job> jobs;

	// @OneToMany(mappedBy = "employee")
	// private List<EmployeeHasProject> projects;

	// @OneToMany(mappedBy = "employee")
	// private List<EmployeeRating> ratings;

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
		return "Employee[" + name + ":JobCount[" + jobs.size() + "]" + "]";
	}
}