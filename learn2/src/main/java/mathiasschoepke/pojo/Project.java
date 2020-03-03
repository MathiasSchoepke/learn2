package mathiasschoepke.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES
	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "seo_url", nullable = false)
	private String seoUrl;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "team_size", nullable = false)
	private int teamSize;

	// ASSOCIATION
	@OneToMany(targetEntity = Job.class, mappedBy = "project")
	private List<Job> jobs;

	@OneToMany(targetEntity = Requirement.class, mappedBy = "project")
	private List<Requirement> requirements;

	// METHODS
	public Project() {
	}

	public Project(String seoUrl, String name, int teamSize) {
		this.seoUrl = seoUrl;
		this.name = name;
		this.teamSize = teamSize;
	}

	public Project(int id, String seoUrl, String name, int teamSize) {
		this.id = id;
		this.seoUrl = seoUrl;
		this.name = name;
		this.teamSize = teamSize;
	}

	@Override
	public String toString() {
		return "Project:" + name;
	}
}