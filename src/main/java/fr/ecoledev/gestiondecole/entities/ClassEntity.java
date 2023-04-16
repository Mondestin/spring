package fr.ecoledev.gestiondecole.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
    @ManyToOne
    @JoinColumn(name="ecoleId", nullable=false)
    private EcoleEntity ecole;


	/**
	 * Empty Constructor
	 */
	public ClassEntity() {}


	public ClassEntity(String classeName, int classeLevel, String classeField, EcoleEntity ecole) {
		super();
		this.classeName = classeName;
		this.classeLevel = classeLevel;
		this.classeField = classeField;
		this.ecole = ecole;
	}

	public Long getClasseId() {
		return classeId;
	}

	public String getClasseName() {
		return classeName;
	}


	public void setClasseName(String classeName) {
		this.classeName = classeName;
	}


	public int getClasseLevel() {
		return classeLevel;
	}


	public void setClasseLevel(int classeLevel) {
		this.classeLevel = classeLevel;
	}


	public String getClasseField() {
		return classeField;
	}


	public void setClasseField(String classeField) {
		this.classeField = classeField;
	}


	public EcoleEntity getEcole() {
		return ecole;
	}


	public void setEcole(EcoleEntity ecole) {
		this.ecole = ecole;
	}

	
}

