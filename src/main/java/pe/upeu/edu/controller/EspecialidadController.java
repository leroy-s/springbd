package pe.upeu.edu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.validation.Valid;
import pe.upeu.edu.entity.Especialidad;
import pe.upeu.edu.service.EspecialidadService;

@RestController
@RequestMapping("/api/especialidad")
@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadController {
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> readAll(){
		try {
			List<Especialidad> Especialidades = especialidadService.readAll();
			if(Especialidades.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Especialidades, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping
	public ResponseEntity<Especialidad> crear(@Valid @RequestBody Especialidad cat){
		try {
			Especialidad c = especialidadService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> getespecialidad(@PathVariable("id") Long id){
		try {
			Especialidad c = especialidadService.read(id).get();
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Especialidad> delespecialidad(@PathVariable("id") Long id){
		try {
			especialidadService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateespecialidad(@PathVariable("id") Long id, @Valid @RequestBody Especialidad cat){

			Optional<Especialidad> c = especialidadService.read(id);
			if(c.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				
				return new ResponseEntity<>(especialidadService.update(cat), HttpStatus.OK);
			}			
	}
}
