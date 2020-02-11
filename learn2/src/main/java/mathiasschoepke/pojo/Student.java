package mathiasschoepke.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Department", nullable = false)
	private String department;

	public Student() {
	}

	public Student(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
}