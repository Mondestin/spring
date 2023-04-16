package fr.ecoledev.gestiondecole.entities;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import fr.ecoledev.gestiondecole.repositories.ClasseRepository;
import fr.ecoledev.gestiondecole.repositories.EcoleRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@OneToMany(mappedBy="classeId")
    private Set<ClassEntity> classes;
	
	@Autowired
	private EcoleRepository erp;
	 
	@Autowired
	private ClasseRepository crp;
	
	/**
	 * Empty Constructor
	 */
	public EcoleEntity() {}


	public EcoleEntity(String ecoleName, String ecoleAddress, String ecolePhone, String ecoleEmail,
			boolean ecoleStatus, Set<ClassEntity> classes) {
		super();
		this.ecoleName = ecoleName;
		this.ecoleAddress = ecoleAddress;
		this.ecolePhone = ecolePhone;
		this.ecoleEmail = ecoleEmail;
		this.ecoleStatus = ecoleStatus;
		this.classes = classes;
	}


	public Long getEcoleId() {
		return ecoleId;
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


	public Set<ClassEntity> getClasses(Long ecoleId) {
		
		return erp.findClassEntityByEcoleId(ecoleId);
    
	}


	public void setClasses(Set<ClassEntity> classes) {
		this.classes = classes;
	}


}
