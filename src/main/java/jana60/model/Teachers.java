package jana60.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column (name = "id")
	
	private Integer teacherId;
	private String name;	
	private String surname;	
	private String phone;	
	private String email;	
	private String officeAddress;	
	private String officeNumber;
	
	@ManyToMany
	@JoinTable(name = "course_teacher", joinColumns = { @JoinColumn(name = "teacherId") }, inverseJoinColumns = {
			@JoinColumn(name = "courseId") })
	private List<Courses> courses;
	
	public Integer getId() {
		return teacherId;
	}

	public void setId(Integer id) {
		this.teacherId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}


	public String nameSurname() {		
	return name + " " + surname;
			
	}
	
	
}
