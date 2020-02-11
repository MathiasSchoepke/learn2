package mathiasschoepke.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.hibernate.Session;

import lombok.Getter;
import mathiasschoepke.pojo.Employee;
import mathiasschoepke.util.HibernateUtil;

@Named
@RequestScoped
public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = -9118480002865047109L;

	@Getter
	private Employee Employee;

	public void getEmployeeById(int id) {
		Session session = null;
		Employee stud = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			stud = (Employee) session.get(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (stud != null) {
			System.out.println(stud.getName() + " " + stud.getSeoUrl());
		}
	}
}
