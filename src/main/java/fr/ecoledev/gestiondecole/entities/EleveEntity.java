package fr.ecoledev.gestiondecole.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eleves")
public class EleveEntity {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer studentNumber;
	private String StudentName;
	private String StudentSurname;
	private String StudentEmail;
	private Integer StudentPhone;
	private String StudentAddress;
	private Integer StudentClass;
	
	/**
	 * Empty Constructor
	 */
	public EleveEntity() {}
	
	public EleveEntity(Integer studentNumber, String studentName, String studentSurname, String studentEmail,
			Integer studentPhone, String studentAddress, Integer studentClass) {
		super();
		this.studentNumber = studentNumber;
		StudentName = studentName;
		StudentSurname = studentSurname;
		StudentEmail = studentEmail;
		StudentPhone = studentPhone;
		StudentAddress = studentAddress;
		StudentClass = studentClass;
		

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentSurname() {
		return StudentSurname;
	}
	public void setStudentSurname(String studentSurname) {
		StudentSurname = studentSurname;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	public Integer getStudentPhone() {
		return StudentPhone;
	}
	public void setStudentPhone(Integer studentPhone) {
		StudentPhone = studentPhone;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	public Integer getStudentClass() {
		return StudentClass;
	}
	public void setStudentClass(Integer studentClass) {
		StudentClass = studentClass;
	}
	
	
	
	
}
