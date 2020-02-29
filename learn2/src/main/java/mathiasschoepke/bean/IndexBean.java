package mathiasschoepke.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mathiasschoepke.pojo.Employee;
import mathiasschoepke.pojo.EmployeeHasProject;
import mathiasschoepke.pojo.EmployeeRating;
import mathiasschoepke.pojo.Project;
import mathiasschoepke.pojo.ProjectRequirement;
import mathiasschoepke.pojo.QEmployee;
import mathiasschoepke.pojo.QEmployeeHasProject;
import mathiasschoepke.pojo.QEmployeeRating;
import mathiasschoepke.pojo.QProject;
import mathiasschoepke.pojo.QProjectRequirement;
import mathiasschoepke.pojo.QRole;
import mathiasschoepke.pojo.QSkill;
import mathiasschoepke.pojo.Role;
import mathiasschoepke.pojo.Skill;

@Named
@ViewScoped
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	SessionBean sb;

	@PostConstruct
	public void init() {
	}

	public void show() {
		System.out.println("--- show! ---");
		QEmployee employee = QEmployee.employee;
		List<Employee> emp = sb.getQueryFactory().selectFrom(employee).fetch();
		System.out.println(emp);

		QProject project = QProject.project;
		List<Project> pro = sb.getQueryFactory().selectFrom(project).fetch();
		System.out.println(pro);

		QSkill skill = QSkill.skill;
		List<Skill> ski = sb.getQueryFactory().selectFrom(skill).fetch();
		System.out.println(ski);

		QRole role = QRole.role;
		List<Role> rol = sb.getQueryFactory().selectFrom(role).fetch();
		System.out.println(rol);

		QEmployeeHasProject employeeHasProject = QEmployeeHasProject.employeeHasProject;
		List<EmployeeHasProject> ehp = sb.getQueryFactory().selectFrom(employeeHasProject).fetch();
		System.out.println(ehp);

		QEmployeeRating employeeRating = QEmployeeRating.employeeRating;
		List<EmployeeRating> er = sb.getQueryFactory().selectFrom(employeeRating).fetch();
		System.out.println(er);

		QProjectRequirement projectRequirement = QProjectRequirement.projectRequirement;
		List<ProjectRequirement> pr = sb.getQueryFactory().selectFrom(projectRequirement).fetch();
		System.out.println(pr);
	}

	public void fill() {
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

		// EmployeeHasProjects
		sb.persist(new EmployeeHasProject(1, 1, 1));
		sb.persist(new EmployeeHasProject(1, 2, 2));

		sb.persist(new EmployeeHasProject(2, 1, 3));
		sb.persist(new EmployeeHasProject(2, 2, 3));

		sb.persist(new EmployeeHasProject(3, 1, 2));
		sb.persist(new EmployeeHasProject(3, 2, 1));

		// EmployeeRatings
		sb.persist(new EmployeeRating(1, 1, 4));
		sb.persist(new EmployeeRating(1, 2, 3));
		sb.persist(new EmployeeRating(1, 3, 2));

		sb.persist(new EmployeeRating(2, 2, 2));
		sb.persist(new EmployeeRating(2, 3, 2));

		sb.persist(new EmployeeRating(3, 1, 3));
		sb.persist(new EmployeeRating(3, 2, 4));
		sb.persist(new EmployeeRating(3, 3, 5));

		// EmployeeRatings
		sb.persist(new ProjectRequirement(1, 1, 3));
		sb.persist(new ProjectRequirement(1, 2, 2));
		sb.persist(new ProjectRequirement(1, 3, 2));

		sb.persist(new ProjectRequirement(2, 1, 2));
		sb.persist(new ProjectRequirement(2, 2, 4));
		sb.persist(new ProjectRequirement(2, 3, 1));
	}
}