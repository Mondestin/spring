package fr.ecoledev.gestiondecole.entities;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ecoles")
public class EcoleEntity {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ecoleId;
	private String ecoleName;
	private String ecoleAddress;
	private String ecolePhone;
	private String ecoleEmail;
	private boolean ecoleStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "fk_ecole_id", referencedColumnName ="ecoleId")
    private List<ClassEntity> classes;
	 
	
	/**
	 * Empty Constructor
	 */
	
	public EcoleEntity() {}


	public EcoleEntity(String ecoleName, String ecoleAddress, String ecolePhone, String ecoleEmail,
			boolean ecoleStatus) {
		super();
		this.ecoleName = ecoleName;
		this.ecoleAddress = ecoleAddress;
		this.ecolePhone = ecolePhone;
		this.ecoleEmail = ecoleEmail;
		this.ecoleStatus = ecoleStatus;

	}


	public Long getEcoleId() {
		return ecoleId;
	}

	public void setEcoleId(Long ecoleId) {
		this.ecoleId = ecoleId;
	}

	public String getEcoleName() {
		return ecoleName;
	}


	public void setEcoleName(String ecoleName) {
		this.ecoleName = ecoleName;
	}


	public String getEcoleAddress() {
		return ecoleAddress;
	}


	public void setEcoleAddress(String ecoleAddress) {
		this.ecoleAddress = ecoleAddress;
	}


	public String getEcolePhone() {
		return ecolePhone;
	}


	public void setEcolePhone(String ecolePhone) {
		this.ecolePhone = ecolePhone;
	}


	public String getEcoleEmail() {
		return ecoleEmail;
	}


	public void setEcoleEmail(String ecoleEmail) {
		this.ecoleEmail = ecoleEmail;
	}


	public boolean isEcoleStatus() {
		return ecoleStatus;
	}


	public void setEcoleStatus(boolean ecoleStatus) {
		this.ecoleStatus = ecoleStatus;
	}


	public List<ClassEntity> getClasses() {
		return classes;
	}


	public void setClasses(List<ClassEntity> classes) {
		this.classes = classes;
	}



}
