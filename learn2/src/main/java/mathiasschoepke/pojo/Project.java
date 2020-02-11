package mathiasschoepke.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {

	@Id
	@Column(name = "projectId")
	private int projectId;

	@Column(name = "seoUrl", nullable = false)
	private String seoUrl;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "teamSize", nullable = false)
	private int teamSize;

	public Project() {
	}

	public Project(int projectId, String seoUrl, String name, int teamSize) {
		this.projectId = projectId;
		this.seoUrl = seoUrl;
		this.name = name;
		this.teamSize = teamSize;
	}
}