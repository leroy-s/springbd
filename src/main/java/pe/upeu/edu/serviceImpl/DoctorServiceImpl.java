package pe.upeu.edu.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.upeu.edu.entity.Doctor;
import pe.upeu.edu.repository.DoctorRepository;
import pe.upeu.edu.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository; 
	@Override
	public Doctor create(Doctor c) {
		// TODO Auto-generated method stub
		return doctorRepository.save(c);
	}

	@Override
	public Doctor update(Doctor c) {
		// TODO Auto-generated method stub
		return doctorRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
	}

	@Override
	public Optional<Doctor> read(Long id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id);
	}

	@Override
	public List<Doctor> readAll() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll(); 
	}

}
