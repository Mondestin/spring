package fr.ecoledev.gestiondecole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  
	
}
