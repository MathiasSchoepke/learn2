package mathiasschoepke.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import mathiasschoepke.pojo.Project;
import mathiasschoepke.pojo.QProject;

@Named
@ViewScoped
public class ProjectsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	private List<Project> projects;
	
	@Getter
	@Setter
	private String urlID;

	@Inject
	SessionBean sb;

	@PostConstruct
	public void init() {
		System.out.println("ProjectsBean Init()");
		QProject project = QProject.project;
		projects = sb.getQueryFactory().selectFrom(project).fetch();
	}
}
