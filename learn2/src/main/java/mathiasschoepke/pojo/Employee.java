package mathiasschoepke.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@Id
	@Column(name = "employeeId")
	private int id;

	@Column(name = "seoUrl", nullable = false)
	private String seoUrl;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_has_project", joinColumns = {@JoinColumn(name = "employeeId")}, inverseJoinColumns = {
			@JoinColumn(name = "projectId")})
	private List<Project> projects = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_has_project", joinColumns = {@JoinColumn(name = "employeeId")}, inverseJoinColumns = {
			@JoinColumn(name = "roleId")})
	private List<Role> roles = new ArrayList<>();

	@OneToMany(mappedBy = "employee")
	private List<EmployeeRating> ratings;

	public Employee() {
	}

	public Employee(int id, String seoUrl, String name) {
		this.id = id;
		this.seoUrl = seoUrl;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}