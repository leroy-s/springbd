 package pe.upeu.edu.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.upeu.edu.entity.Especialidad;
import pe.upeu.edu.repository.EspecialidadRepository;
import pe.upeu.edu.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	@Autowired
	private EspecialidadRepository especialidadRepository; 
	@Override
	public Especialidad create(Especialidad c) {
		// TODO Auto-generated method stub
		return especialidadRepository.save(c);
	}

	@Override
	public Especialidad update(Especialidad c) {
		// TODO Auto-generated method stub
		return especialidadRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		especialidadRepository.deleteById(id);
	}

	@Override
	public Optional<Especialidad> read(Long id) {
		// TODO Auto-generated method stub
		return especialidadRepository.findById(id);
	}

	@Override
	public List<Especialidad> readAll() {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}
	
	
}
