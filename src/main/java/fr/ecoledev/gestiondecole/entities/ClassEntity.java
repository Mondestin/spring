package fr.ecoledev.gestiondecole.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import fr.ecoledev.gestiondecole.entities.EcoleEntity;

@Entity
@Table(name = "classes")
public class ClassEntity {
   
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long classeId;
	private String classeName;
	private int classeLevel;
	private String classeField;
	
	/*private EcoleEntity fk_ecole_id; */
	

	


	/**
	 * Empty Constructor
	 */
	public ClassEntity() {}
	
	




	public ClassEntity(String classeName, int classeLevel, String classeField, EcoleEntity fk_ecole_id) {
		super();
		this.classeName = classeName;
		this.classeLevel = classeLevel;
		this.classeField = classeField;
		/*this.fk_ecole_id = fk_ecole_id;*/
		
	}

	public Long getClasseId() {
		return classeId;
	}

	public void setClasseId(Long classeId) {
		this.classeId = classeId;
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
	
	/*public EcoleEntity getFk_ecole_id() {
		return fk_ecole_id;
	}
	public void setFk_ecole_id(EcoleEntity fk_ecole_id) {
		this.fk_ecole_id = fk_ecole_id;
	} */


	
}

