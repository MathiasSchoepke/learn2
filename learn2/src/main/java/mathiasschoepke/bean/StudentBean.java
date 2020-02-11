package mathiasschoepke.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.hibernate.Session;

import lombok.Getter;
import mathiasschoepke.pojo.Student;
import mathiasschoepke.util.HibernateUtil;

@Named
@RequestScoped
public class StudentBean implements Serializable {
	private static final long serialVersionUID = -9118480002865047109L;

	@Getter
	private Student student;

	// private SessionFactory factory;
	// private Session session;

	// @PostConstruct
	// public void intit() {
	// System.out.println("init");
	// factory = HibernateUtil.getSessionFactory();
	// session = factory.getCurrentSession();
	// }

	public void getStudentById(int id) {
		Session session = null;
		Student stud = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			stud = (Student) session.get(Student.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (stud != null) {
			System.out.println(stud.getName() + " " + stud.getDepartment());
		}
		// System.out.println("getStudentById: " + id);
		// session.getTransaction().begin();
		// String query = "SELCET s FROM Student c WHERE c.id = :studentId";
		// Query<Student> tq = session.createQuery(query, Student.class);
		// tq.setParameter("studentId", id);
		// try {
		// Student stud = tq.getSingleResult();
		// System.out.println(stud.getName() + " " + stud.getDepartment());
		// return stud.getName();
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// session.getTransaction().rollback();
		// } finally {
		// if (session != null && session.isOpen()) {
		// session.close();
		// }
		// }
		//
	}
	public void print() {
		System.out.println("just print something!");
	}
}
