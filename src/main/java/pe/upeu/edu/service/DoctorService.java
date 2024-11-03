package pe.upeu.edu.service;

import java.util.List;
import java.util.Optional;

import pe.upeu.edu.entity.Doctor;


public interface DoctorService {
	Doctor create(Doctor c);
	Doctor update(Doctor c);
	void delete(Long id);
	Optional<Doctor> read(Long id);
	List<Doctor> readAll();
}
