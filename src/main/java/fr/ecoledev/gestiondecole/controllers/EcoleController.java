package fr.ecoledev.gestiondecole.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ecoledev.gestiondecole.entities.EcoleEntity;

import fr.ecoledev.gestiondecole.repositories.EcoleRepository;

@RestController
@RequestMapping(path="/ecoles")
public class EcoleController {
	
	@Autowired
	private EcoleRepository erp;

  @GetMapping("")
  public Iterable<EcoleEntity> getAllEcoles() {
	  
    return erp.findAll();
  }
  
  @PostMapping("/save")
  public ResponseEntity<String> saveEcole(@RequestBody List<EcoleEntity> ecoleData) {
	  
	erp.saveAll(ecoleData);
	  
    return ResponseEntity.ok("Ecole (s) added successfully");
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<EcoleEntity> getEcole(@PathVariable Long id) {
      try {
    	  EcoleEntity ecole = erp.findById(id).get();
    	  
          return new ResponseEntity<EcoleEntity>(ecole, HttpStatus.OK);
      } catch (NoSuchElementException e) {
    	  
          return new ResponseEntity<EcoleEntity>(HttpStatus.NOT_FOUND);
      }      
  }
  
  @PatchMapping("/{id}")
  public ResponseEntity<?> updateEcole(@RequestBody EcoleEntity ecole, @PathVariable Long id) {
      try {
    	  EcoleEntity existEcole = erp.findById(id).get();
    	  erp.save(ecole);
          return new ResponseEntity<>(HttpStatus.OK);
      } catch (NoSuchElementException e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }      
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {

	  try {
    	  EcoleEntity existEcole = erp.findById(id).get();
    	  erp.deleteById(id);
    	  
          String message="Ecole deleted successfully";
		return ResponseEntity.ok(message);
      } catch (NoSuchElementException e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }  
  }

}
