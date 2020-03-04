package mathiasschoepke.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import mathiasschoepke.pojo.Employee;
import mathiasschoepke.pojo.QEmployee;

@Named
@ViewScoped
public class EmployeesBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String name;

	@Getter
	private List<Employee> employees;
	
	@Getter
	@Setter
	private String urlID;

	@Inject
	SessionBean sb;

	@PostConstruct
	public void init() {
		System.out.println("EmployeesBean Init()");
		QEmployee employee = QEmployee.employee;
		employees = loadAllEmployees();
	}

	private List<Employee> loadAllEmployees() {
		QEmployee employee = QEmployee.employee;
		return sb.getQueryFactory().selectFrom(employee).fetch();
	}

	public Object createEmployee(String name) {
		Employee new_employee = new Employee(convertNameToUrl(name), name);
		sb.persist(new_employee);
		System.out.println("createEmployee:" + new_employee);
		employees = loadAllEmployees();
		return new_employee;
	}

	private String convertNameToUrl(String name) {
		String url = name.trim().toLowerCase().replaceAll("[^a-z0-9_\\s-]", "");
		url = url.replaceAll("[\\s-]+", " ");
		url = url.replaceAll("[\\s]", "-");
		url += "-";
		return url;
	}
}
