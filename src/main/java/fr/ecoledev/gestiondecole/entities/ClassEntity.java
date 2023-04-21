package fr.ecoledev.gestiondecole.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class ClassEntity {
   
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long classeId;
	private String classeName;
	private int classeLevel;
	private String classeField;
	

	/**
	 * Empty Constructor
	 */
	public ClassEntity() {}
	

	/**
	 * @param classeName
	 * @param classeLevel
	 * @param classeField
	 */
	public ClassEntity(String classeName, int classeLevel, String classeField) {
		super();
		this.classeName = classeName;
		this.classeLevel = classeLevel;
		this.classeField = classeField;	
	}

	/**
	 * @return classeId
	 */
	public Long getClasseId() {
		return classeId;
	}

	/**
	 * @param classeId
	 */
	public void setClasseId(Long classeId) {
		this.classeId = classeId;
	}


	/**
	 * @return classeName
	 */
	public String getClasseName() {
		return classeName;
	}


	/**
	 * @param classeName
	 */
	public void setClasseName(String classeName) {
		this.classeName = classeName;
	}


	/**
	 * @return classeLevel
	 */
	public int getClasseLevel() {
		return classeLevel;
	}


	/**
	 * @param classeLevel
	 */
	public void setClasseLevel(int classeLevel) {
		this.classeLevel = classeLevel;
	}


	/**
	 * @return classeField
	 */
	public String getClasseField() {
		return classeField;
	}


	/**
	 * @param classeField
	 */
	public void setClasseField(String classeField) {
		this.classeField = classeField;
	}

	
	
}

