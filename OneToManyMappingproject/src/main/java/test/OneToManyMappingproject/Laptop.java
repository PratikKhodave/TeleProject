package test.OneToManyMappingproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lap_id;
	private String lap_name;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public int getLap_id() {
		return lap_id;
	}

	public void setLap_id(int lap_id) {
		this.lap_id = lap_id;
	}

	public String getLap_name() {
		return lap_name;
	}

	public void setLap_name(String lap_name) {
		this.lap_name = lap_name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
