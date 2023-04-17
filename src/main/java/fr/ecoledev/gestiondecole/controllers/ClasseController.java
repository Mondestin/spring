package fr.ecoledev.gestiondecole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ecoledev.gestiondecole.entities.ClassEntity;
import fr.ecoledev.gestiondecole.repositories.ClasseRepository;


@RestController
@RequestMapping(path="/classes")
public class ClasseController {

	@Autowired
	private ClasseRepository crp;
	
	 @GetMapping("")
	  public Iterable<ClassEntity> getAllClasses() {
		  
	    return crp.findAll();
	  }
}
