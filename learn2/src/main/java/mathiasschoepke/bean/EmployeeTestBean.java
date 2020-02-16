package mathiasschoepke.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
// @RequestScoped

// @ELBeanName(value = "employeeTestBean")
// @Join(path = "/employees/{id}", to = "/employee.xhtml")
public class EmployeeTestBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	// @Parameter("id")
	private String urlId;

	// @Getter
	// private List<Employee> employees;
	//
	// @Inject
	// EmployeeBean employeeBean;

	@PostConstruct
	public void init() {
		// employees = employeeBean.getAll();
		// System.out.println("id: " + urlId);
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		urlId = params.get("id");
		System.out.println("id: " + urlId);
	}
}
