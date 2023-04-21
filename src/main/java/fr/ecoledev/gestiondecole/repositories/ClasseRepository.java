package fr.ecoledev.gestiondecole.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ecoledev.gestiondecole.entities.ClassEntity;
import fr.ecoledev.gestiondecole.entities.EcoleEntity;

@Repository
public interface ClasseRepository extends JpaRepository<ClassEntity, Long> {

	 /**
	 * return list of Classes with pagination
	 */
	Page<ClassEntity> findAll(Pageable pageable);
	 
	/**
	 * @param name
	 * @return list 
	 */
	List<ClassEntity> findByClasseNameContainingIgnoreCase(String name);

}
