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
import fr.ecoledev.gestiondecole.entities.EcoleEntity;
import fr.ecoledev.gestiondecole.repositories.ClasseRepository;
import fr.ecoledev.gestiondecole.repositories.EcoleRepository;

@RestController
@RequestMapping(path="/ecoles")
public class EcoleController {
	
	@Autowired
	private EcoleRepository erp;
	private ClasseRepository classRep;

  @GetMapping("/all")
  public Iterable<EcoleEntity> getAllEcoles() {
	  
    return this.erp.findAll();
  }
  
  /*@GetMapping("/{id}/classes")
  public ResponseEntity<List<ClassEntity>> getClassesByClassId(@PathVariable Long id) {
      Optional<ClassEntity> optionalClass = classRep.findById(id);
      if (optionalClass.isPresent()) {
          List<ClassEntity> classes = optionalClass.get().getClasseId();
          return ResponseEntity.ok(classes);
      } else {
          return ResponseEntity.notFound().build();
      }
  }*/

  
  @PostMapping("/save")
  public ResponseEntity<String> saveEcole(@RequestBody List<EcoleEntity> ecoleData) {
	  
	erp.saveAll(ecoleData);
	  
    return ResponseEntity.ok("Ecole (s) added successfully");
  }
  
  @DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClasse(@PathVariable Long id) {
		Optional<EcoleEntity> optionalClass = erp.findById(id);
		if (optionalClass.isPresent()) {
			erp.delete(optionalClass.get());
			return ResponseEntity.ok("Ecole with ID " + id + " deleted successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
 
}
