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

@Named
@ViewScoped
public class EmployeesBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	private List<Employee> employees;
	
	@Getter
	@Setter
	private String urlID;

	@Inject
	EmployeeBean employeeBean;

	@PostConstruct
	public void init() {
		employees = employeeBean.getAll();
	}
}
