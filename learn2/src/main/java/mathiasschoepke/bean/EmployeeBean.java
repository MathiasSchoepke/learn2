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
	@Getter
	@Setter
	private String name;

	@Inject
	SessionBean sb;

	@PostConstruct
	public void init() {
		System.out.println("EmployeeBean Init()");
		// Thread.dumpStack();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (params.containsKey("id")) {
			System.out.println(params.get("id"));
			url = params.get("id");
			String[] split = url.split("-");
			if (split.length != 0) {
				long id;
				try {
					id = (long) Long.parseLong(split[split.length - 1]);
					emp = (Employee) readEmployee(id);
					name = emp.getName();
				} catch (NumberFormatException nfe) {
					// nfe.printStackTrace();
					System.out.println("no employee 1");
				}
			} else {
				System.out.println("no employee 2");
			}
		}
		System.out.println(emp);
	}

	private Object readEmployee(long id) {
		QEmployee employee = QEmployee.employee;
		Employee emp = sb.getQueryFactory().selectFrom(employee).where(employee.id.eq(id)).fetchOne();
		return emp;
	}

	public Object updateEmployee() {
		System.out.println("updateEmployee");
		emp.setName(name);
		emp.setSeoUrl(convertNameToUrl(name));

		System.out.println(emp);

		sb.getEm().getTransaction().begin();
		sb.getEm().merge(emp);
		sb.getEm().getTransaction().commit();
		return null;
	}

	private String convertNameToUrl(String name) {
		String url = name.trim().toLowerCase().replaceAll("[^a-z0-9_\\s-]", "");
		url = url.replaceAll("[\\s-]+", " ");
		url = url.replaceAll("[\\s]", "-");
		url += "-";
		return url;
	}
}
