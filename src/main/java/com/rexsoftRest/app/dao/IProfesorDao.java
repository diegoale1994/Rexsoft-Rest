package com.rexsoftRest.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rexsoftRest.app.entity.Profesor;

public interface IProfesorDao extends JpaRepository<Profesor, Long> {

	public Profesor findByEmail(String email);
	public Profesor findByEmailAndPassword(String email, String password);
	public Optional<Profesor> findById(long id);
	
	@Query("select p from Profesor p where p.id =?1")
	public Profesor findByIdSQL(long id);
}
