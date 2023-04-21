package fr.ecoledev.gestiondecole.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ecoledev.gestiondecole.entities.ClassEntity;
import fr.ecoledev.gestiondecole.entities.EcoleEntity;
import fr.ecoledev.gestiondecole.repositories.ClasseRepository;

@RestController
@RequestMapping(path= "/classes")

public class ClasseController {
	
	@Autowired
	private ClasseRepository classRep;
	
	/**
	 * @return all classes 
	 */
	@GetMapping("/all")  
	public Iterable<ClassEntity> getAllClasses() {
		return this.classRep.findAll();
	}
	
	/**
	 * @param classData
	 * @return success message
	 */
	@PostMapping ("/save") 
	public ResponseEntity<String> saveClasse(@RequestBody List<ClassEntity> classData) {
		classRep.saveAll(classData);
		
		return ResponseEntity.ok("Classe added successfully");
	}
	
	/**
	 * @param classe
	 * @param id
	 * @return message
	 */
	@PatchMapping("/{id}")
	  public ResponseEntity<?> updateClasse(@RequestBody ClassEntity classe, @PathVariable Long id) {
	      try {
	    	  ClassEntity existClass = classRep.findById(id).get();
	    	  classRep.save(classe);
	    	  return ResponseEntity.ok("Classe upadated successfully");
	      } catch (NoSuchElementException e) {
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }      
	  }
	
	/**
	 * @param id
	 * @return message
	 */
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> deleteClasse(@PathVariable Long id) {
		Optional<ClassEntity> optionalClass = classRep.findById(id);
		if (optionalClass.isPresent()) {
			classRep.delete(optionalClass.get());
			return ResponseEntity.ok("Class with ID " + id + " deleted successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/**
	 * @param page
	 * @param size
	 * @return List of classes
	 */
	@GetMapping("/pagination") 
    public ResponseEntity<List<ClassEntity>> getClassesByPages(@RequestParam int page, int size) {
		  Pageable pageable = PageRequest.of(page, size);
		  
		  Page<ClassEntity> classes = classRep.findAll(pageable);
	        return ResponseEntity.ok(classes.getContent());
	      
    }
	  
	/**
	 * @param name
	 * @return List of classes
	 */
	@GetMapping(params = { "name" })
	    public List<ClassEntity> findClasseByClaseName(@RequestParam("name") String name) {
	        return classRep.findByClasseNameContainingIgnoreCase(name);
	  }
	  


}
	


