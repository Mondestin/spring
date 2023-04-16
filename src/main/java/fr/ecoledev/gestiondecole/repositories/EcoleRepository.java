package fr.ecoledev.gestiondecole.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.ecoledev.gestiondecole.entities.ClassEntity;
import fr.ecoledev.gestiondecole.entities.EcoleEntity;

public interface EcoleRepository extends JpaRepository<EcoleEntity, Long>{
	 Set<ClassEntity> findClassEntityByEcoleId(Long ecoleId);
}
