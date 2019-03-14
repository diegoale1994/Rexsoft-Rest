package com.rexsoftRest.app.services;

import java.util.List;
import java.util.Optional;

import com.rexsoftRest.app.entity.Profesor;

public interface IProfesorService {

	public List<Profesor> findAll();
	public Profesor findProfesor(Profesor profesor);
	public Profesor checkProfesorLogin(Profesor profesor);
	public void deleteProfesor(Profesor profesor);
	public Profesor updateProfesor(Profesor profesor);
	public Optional<Profesor> findProfesorId(Long id);
	public void deleteProfesor(Long Id);
	public Profesor ProfesorfindById(Long id);
	public Profesor ProfesorfindByIdSQL(Long id);
}
