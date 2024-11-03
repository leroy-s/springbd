package pe.upeu.edu.service;

import java.util.List;
import java.util.Optional;

import pe.upeu.edu.entity.Especialidad;


public interface EspecialidadService {
	Especialidad create(Especialidad c);
	Especialidad update(Especialidad c);
	void delete(Long id);
	Optional<Especialidad> read(Long id);
	List<Especialidad> readAll();
}
