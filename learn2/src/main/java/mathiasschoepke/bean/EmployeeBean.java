package mathiasschoepke.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import mathiasschoepke.pojo.Employee;
import mathiasschoepke.pojo.QEmployee;

@Named
// @RequestScoped
@ViewScoped
public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String url;

	@Getter
	@Setter
	private Employee emp;

	@Inject
	SessionBean sb;

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		url = params.get("id");
		String[] split = url.split("-");
		if (split.length != 0) {
			long id;
			try {
				id = (long) Long.parseLong(split[split.length - 1]);
				emp = (Employee) readEmployee(id);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				emp = new Employee();
			}
		} else {
			emp = new Employee();
		}
	}

	private Object readEmployee(long id) {
		QEmployee employee = QEmployee.employee;
		Employee emp = sb.getQueryFactory().selectFrom(employee).where(employee.id.eq(id)).fetchOne();
		return emp;
	}
}
