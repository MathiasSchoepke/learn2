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
import mathiasschoepke.pojo.Project;
import mathiasschoepke.pojo.QProject;

@Named
// @RequestScoped
@ViewScoped
public class ProjectBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String url;

	@Getter
	@Setter
	private Project project;

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
				project = (Project) readProject(id);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				project = new Project();
			}
		} else {
			project = new Project();
		}
	}

	private Object readProject(long id) {
		QProject project = QProject.project;
		Project pro = sb.getQueryFactory().selectFrom(project).where(project.id.eq(id)).fetchOne();
		return pro;
	}
}
