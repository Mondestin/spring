package fr.ecoledev.gestiondecole.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ecoledev.gestiondecole.entities.EcoleEntity;
import fr.ecoledev.gestiondecole.entities.ClassEntity;
import fr.ecoledev.gestiondecole.repositories.EcoleRepository;
import fr.ecoledev.gestiondecole.exceptions.ResourceNotFoundException;


import fr.ecoledev.gestiondecole.repositories.ClasseRepository;

@RestController
@RequestMapping(path="/ecoles")
public class EcoleController {
	
	@Autowired
	private EcoleRepository erp;
	private ClasseRepository classRep;

  /**
 * @return List of Ecoles
 */
@GetMapping("/all")
  public Iterable<EcoleEntity> getAllEcoles() {
	  
    return this.erp.findAll();
  }
  
  /**
 * @param id
 * @return ecole by id
 */
 @GetMapping("/{id}")
  public ResponseEntity<EcoleEntity> getEcole(@PathVariable Long id) {
      try {
    	  EcoleEntity ecole = erp.findById(id).get();
    	  
          return new ResponseEntity<EcoleEntity>(ecole, HttpStatus.OK);
      } catch (NoSuchElementException e) {
    	  
          return new ResponseEntity<EcoleEntity>(HttpStatus.NOT_FOUND);
      }      
  }
  
  /**
 * @param ecole
 * @param id
 * @return message
 */
 @PatchMapping("/{id}")
  public ResponseEntity<?> updateEcole(@RequestBody EcoleEntity ecole, @PathVariable Long id) {
      try {
    	  EcoleEntity existEcole = erp.findById(id).get();
    	  erp.save(ecole);
    	  return ResponseEntity.ok("Ecole updated successfully");
      } catch (NoSuchElementException e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }      
  } 
  
  /**
 * @param ecoleData
 * @return message
 */
  @PostMapping("/save")
  public ResponseEntity<String> saveEcole(@RequestBody List<EcoleEntity> ecoleData) {
	  
	erp.saveAll(ecoleData);
	  
    return ResponseEntity.ok("Ecole (s) added successfully");
  }
  
  /**
 * @param id
 * @return message
 */
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
