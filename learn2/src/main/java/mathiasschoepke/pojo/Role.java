package mathiasschoepke.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {

	@Id
	@Column(name = "roleId")
	private int roleId;

	@Column(name = "name", nullable = false)
	private String name;

	public Role() {
	}

	public Role(int roleId, String seoUrl, String name) {
		this.roleId = roleId;
		this.name = name;
	}
}