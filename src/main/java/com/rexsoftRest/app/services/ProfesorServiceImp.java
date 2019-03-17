package com.rexsoftRest.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rexsoftRest.app.dao.IProfesorDao;
import com.rexsoftRest.app.entity.Profesor;

@Service
public class ProfesorServiceImp implements IProfesorService {

	@Autowired
	private IProfesorDao profesorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findProfesor(Profesor profesor) {
		return profesorDao.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor checkProfesorLogin(Profesor profesor) {
		return (Profesor) profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional
	public void deleteProfesor(Profesor profesor) {
		profesorDao.deleteById(profesor.getId());
	}

	@Override
	@Transactional
	public Profesor updateProfesor(Profesor profesor) {
		return (Profesor) profesorDao.save(profesor);
	}

	@Transactional(readOnly = true)
	public Optional<Profesor> findProfesorId(Long id) {
		return (Optional<Profesor>) profesorDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteProfesor(Long Id) {
		profesorDao.deleteById(Id);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor ProfesorfindById(Long id) {
		return (Profesor) profesorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor ProfesorfindByIdSQL(Long id) {
		return (Profesor) profesorDao.findByIdSQL(id);
	}

	@Override
	@Transactional
	public void save(Profesor profesor) {
		profesorDao.save(profesor);
	}

}
