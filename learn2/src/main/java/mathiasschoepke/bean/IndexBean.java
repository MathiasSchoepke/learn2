package mathiasschoepke.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mathiasschoepke.pojo.Employee;
import mathiasschoepke.pojo.QEmployee;

@Named
@ViewScoped
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	SessionBean sb;

	@PostConstruct
	public void init() {
	}

	public void test() {
		QEmployee employee = QEmployee.employee;
		List<Employee> c = sb.getQueryFactory().selectFrom(employee).fetch();
		System.out.println(c.get(0));
		System.out.println(c.get(1));
		System.out.println(c.get(1).getRatings());

	}
}
