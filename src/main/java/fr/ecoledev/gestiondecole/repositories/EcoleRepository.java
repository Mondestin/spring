package fr.ecoledev.gestiondecole.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ecoledev.gestiondecole.entities.ClassEntity;
import fr.ecoledev.gestiondecole.entities.EcoleEntity;

@Repository
public interface EcoleRepository extends JpaRepository<EcoleEntity, Long>{

}
