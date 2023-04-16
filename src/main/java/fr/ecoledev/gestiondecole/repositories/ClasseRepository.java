package fr.ecoledev.gestiondecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ecoledev.gestiondecole.entities.ClassEntity;

@Repository
public interface ClasseRepository extends JpaRepository<ClassEntity, Long> {

}
