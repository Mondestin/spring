package fr.ecoledev.gestiondecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.ecoledev.gestiondecole.entities.ClassEntity;

public interface ClasseRepository extends JpaRepository<ClassEntity, Long> {

}
