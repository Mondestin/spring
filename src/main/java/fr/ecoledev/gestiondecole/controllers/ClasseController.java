package fr.ecoledev.gestiondecole.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ecoledev.gestiondecole.entities.ClassEntity;
import fr.ecoledev.gestiondecole.repositories.ClasseRepository;

@RestController
@RequestMapping(path= "/classes")

public class ClasseController {
	
	@Autowired
	private ClasseRepository classRep;
	
	@GetMapping("/all")  /* récuperer les classes */
	public Iterable<ClassEntity> getAllClasses() {
		return this.classRep.findAll();
	}
	
	@PostMapping ("/save") /* creer une classe */
	public ResponseEntity<String> saveClasse(@RequestBody List<ClassEntity> classData) {
		classRep.saveAll(classData);
		
		return ResponseEntity.ok("Classe added successfully");
	}
	
	@DeleteMapping("/{id}") /* supprimer une classe spécifique par ID*/
	public ResponseEntity<String> deleteClasse(@PathVariable Long id) {
		Optional<ClassEntity> optionalClass = classRep.findById(id);
		if (optionalClass.isPresent()) {
			classRep.delete(optionalClass.get());
			return ResponseEntity.ok("Class with ID " + id + " deleted successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
	


