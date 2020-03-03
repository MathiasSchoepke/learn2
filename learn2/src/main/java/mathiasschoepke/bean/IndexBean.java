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
import mathiasschoepke.pojo.Job;
import mathiasschoepke.pojo.Project;
import mathiasschoepke.pojo.QEmployee;
import mathiasschoepke.pojo.QJob;
import mathiasschoepke.pojo.QProject;
import mathiasschoepke.pojo.QRating;
import mathiasschoepke.pojo.QRequirement;
import mathiasschoepke.pojo.QRole;
import mathiasschoepke.pojo.QSkill;
import mathiasschoepke.pojo.Rating;
import mathiasschoepke.pojo.Requirement;
import mathiasschoepke.pojo.Role;
import mathiasschoepke.pojo.Skill;

@Named
@ViewScoped
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String empName;
	@Setter
	@Getter
	private String empId;

	@Inject
	SessionBean sb;

	@PostConstruct
	public void init() {
	}

	public void show(String para) {
		switch (para) {
			case "employee" :
				QEmployee employee = QEmployee.employee;
				List<Employee> emp = sb.getQueryFactory().selectFrom(employee).fetch();
				System.out.println(emp);
				break;

			case "project" :
				QProject project = QProject.project;
				List<Project> pro = sb.getQueryFactory().selectFrom(project).fetch();
				System.out.println(pro);
				break;

			case "skill" :
				QSkill skill = QSkill.skill;
				List<Skill> ski = sb.getQueryFactory().selectFrom(skill).fetch();
				System.out.println(ski);
				break;

			case "role" :
				QRole role = QRole.role;
				List<Role> rol = sb.getQueryFactory().selectFrom(role).fetch();
				System.out.println(rol);
				break;

			case "rating" :
				QRating rating = QRating.rating1;
				List<Rating> er = sb.getQueryFactory().selectFrom(rating).fetch();
				System.out.println(er);
				break;

			case "requirement" :
				QRequirement requirement = QRequirement.requirement;
				List<Requirement> pr = sb.getQueryFactory().selectFrom(requirement).fetch();
				System.out.println(pr);
				break;

			case "job" :
				QJob job = QJob.job;
				List<Job> jo = sb.getQueryFactory().selectFrom(job).fetch();
				System.out.println(jo);
				break;

			default :
				break;
		}
	}

	public void show2() {
		QEmployee employee = QEmployee.employee;
		List<Employee> emp = sb.getQueryFactory().selectFrom(employee).fetch();
		QProject project = QProject.project;
		List<Project> pro = sb.getQueryFactory().selectFrom(project).fetch();

		System.out.println(emp.get(0));
		System.out.println(emp.get(0).getJobs());
		System.out.println(emp.get(0).getRatings());
		System.out.println(pro.get(0));
		System.out.println(pro.get(0).getJobs());
	}

	public void fill() {
		System.out.println("--- fill! ---");

		QEmployee employee = QEmployee.employee;
		List<Employee> emp = sb.getQueryFactory().selectFrom(employee).fetch();
		QProject project = QProject.project;
		List<Project> pro = sb.getQueryFactory().selectFrom(project).fetch();
		QRole role = QRole.role;
		List<Role> rol = sb.getQueryFactory().selectFrom(role).fetch();
		QSkill skill = QSkill.skill;
		List<Skill> ski = sb.getQueryFactory().selectFrom(skill).fetch();

		// sb.persist(new Requirement(pro.get(0), ski.get(0), 3));

	}
	public void initFill() {
		System.out.println("--- fill! ---");

		// EMPLOYEES
		sb.persist(new Employee("max-musterman-", "Max Musterman"));
		sb.persist(new Employee("andre-anders-", "Andre Anders"));
		sb.persist(new Employee("peter-pan-", "Peter Pan"));

		// PROJECTS
		sb.persist(new Project("some-project-", "Some Project", 4));
		sb.persist(new Project("another-project-", "Another Project", 7));

		// SKILLS
		sb.persist(new Skill("Leadership"));
		sb.persist(new Skill("Systemdesign"));
		sb.persist(new Skill("Fronted Engineering"));

		// ROLES
		sb.persist(new Role("Project Manager"));
		sb.persist(new Role("Worker"));
		sb.persist(new Role("QA"));

		QEmployee employee = QEmployee.employee;
		List<Employee> emp = sb.getQueryFactory().selectFrom(employee).fetch();
		QProject project = QProject.project;
		List<Project> pro = sb.getQueryFactory().selectFrom(project).fetch();
		QRole role = QRole.role;
		List<Role> rol = sb.getQueryFactory().selectFrom(role).fetch();
		QSkill skill = QSkill.skill;
		List<Skill> ski = sb.getQueryFactory().selectFrom(skill).fetch();

		sb.persist(new Job(emp.get(0), pro.get(0), rol.get(0)));
		sb.persist(new Job(emp.get(0), pro.get(1), rol.get(1)));
		sb.persist(new Job(emp.get(1), pro.get(0), rol.get(2)));
		sb.persist(new Job(emp.get(1), pro.get(1), rol.get(2)));
		sb.persist(new Job(emp.get(2), pro.get(0), rol.get(1)));
		sb.persist(new Job(emp.get(2), pro.get(1), rol.get(0)));

		sb.persist(new Rating(emp.get(0), ski.get(0), 4));
		sb.persist(new Rating(emp.get(0), ski.get(1), 3));
		sb.persist(new Rating(emp.get(0), ski.get(2), 2));
		sb.persist(new Rating(emp.get(1), ski.get(1), 2));
		sb.persist(new Rating(emp.get(1), ski.get(2), 2));
		sb.persist(new Rating(emp.get(2), ski.get(0), 3));
		sb.persist(new Rating(emp.get(2), ski.get(1), 4));
		sb.persist(new Rating(emp.get(2), ski.get(2), 4));

		sb.persist(new Requirement(pro.get(0), ski.get(0), 3));
		sb.persist(new Requirement(pro.get(0), ski.get(1), 2));
		sb.persist(new Requirement(pro.get(0), ski.get(2), 2));
		sb.persist(new Requirement(pro.get(1), ski.get(0), 2));
		sb.persist(new Requirement(pro.get(1), ski.get(1), 4));
		sb.persist(new Requirement(pro.get(1), ski.get(2), 1));
	}

	public Object createEmployee(String name) {
		Employee new_employee = new Employee(convertNameToUrl(name), name);
		sb.persist(new_employee);
		System.out.println("createEmployee:" + new_employee);
		return new_employee;
	}
	public Object readEmployee(long id) {
		QEmployee employee = QEmployee.employee;
		Employee emp = sb.getQueryFactory().selectFrom(employee).where(employee.id.eq(id)).fetchOne();
		System.out.println("readEmployee: " + emp);
		return emp;
	}
	public Object updateEmployee(long id, String name) {
		System.out.println(id + ":" + name + ":" + convertNameToUrl(name));
		QEmployee employee = QEmployee.employee;

		sb.getEm().getTransaction().begin();
		sb.getQueryFactory().update(employee).where(employee.id.eq(id)).set(employee.name, name)
				.set(employee.seoUrl, convertNameToUrl(name)).execute();
		System.out.println("updateEmployee:" + id);
		sb.getEm().getTransaction().commit();
		return null;
	}
	public Object deleteEmployee(long id) {
		QEmployee employee = QEmployee.employee;

		sb.getEm().getTransaction().begin();
		sb.getQueryFactory().delete(employee).where(employee.id.eq(id)).execute();
		System.out.println("deleteEmployee:" + id);
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