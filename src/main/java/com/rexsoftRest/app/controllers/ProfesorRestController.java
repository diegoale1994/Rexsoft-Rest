package com.rexsoftRest.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rexsoftRest.app.entity.Profesor;
import com.rexsoftRest.app.services.IProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {

	@Autowired
	private IProfesorService profesorService;

	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores() {
		return profesorService.findAll();
	}

	@PostMapping("/sign_up")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {
		if (profesorService.findProfesor(profesor) == null) {
			profesorService.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProfesor(@PathVariable("id") long id, @RequestBody Profesor profesor) {
			Profesor profesorDb = null;
			profesorDb = profesorService.ProfesorfindById(id);
			if (profesorDb != null) {
				profesorDb.setNombre(profesor.getNombre());
				profesorDb.setEmail(profesor.getEmail());
				profesorService.updateProfesor(profesorDb);
				return new ResponseEntity<>(profesorDb,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			

	}
	
}
