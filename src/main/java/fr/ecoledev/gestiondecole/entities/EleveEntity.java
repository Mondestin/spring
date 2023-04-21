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
	
	/**
	 * @param studentNumber
	 * @param studentName
	 * @param studentSurname
	 * @param studentEmail
	 * @param studentPhone
	 * @param studentAddress
	 * @param studentClass
	 */
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
	
	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return studentNumber
	 */
	public Integer getStudentNumber() {
		return studentNumber;
	}
	
	/**
	 * @param studentNumber
	 */
	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}
	/**
	 * @return StudentName
	 */
	public String getStudentName() {
		return StudentName;
	}
	/**
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	/**
	 * @return StudentSurname
	 */
	public String getStudentSurname() {
		return StudentSurname;
	}
	/**
	 * @param studentSurname
	 */
	public void setStudentSurname(String studentSurname) {
		StudentSurname = studentSurname;
	}
	/**
	 * @return StudentEmail
	 */
	public String getStudentEmail() {
		return StudentEmail;
	}
	/**
	 * @param studentEmail
	 */
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	/**
	 * @return StudentPhone
	 */
	public Integer getStudentPhone() {
		return StudentPhone;
	}
	/**
	 * @param studentPhone
	 */
	public void setStudentPhone(Integer studentPhone) {
		StudentPhone = studentPhone;
	}
	/**
	 * @return StudentAddress
	 */
	public String getStudentAddress() {
		return StudentAddress;
	}
	/**
	 * @param studentAddress
	 */
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	/**
	 * @return StudentClass
	 */
	public Integer getStudentClass() {
		return StudentClass;
	}
	/**
	 * @param studentClass
	 */
	public void setStudentClass(Integer studentClass) {
		StudentClass = studentClass;
	}
	
	
	
	
}
