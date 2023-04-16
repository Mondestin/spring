package fr.ecoledev.gestiondecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("/all")
  public Iterable<EcoleEntity> getAllEcoles() {
	  
    return this.erp.findAll();
  }
  
  @PostMapping("/save")
  public ResponseEntity<String> saveEcole(@RequestBody List<EcoleEntity> ecoleData) {
	  
	erp.saveAll(ecoleData);
	  
    return ResponseEntity.ok("Ecole (s) added successfully");
  }

}
