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
import pe.upeu.edu.entity.Doctor;
import pe.upeu.edu.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "http://localhost:4200") 
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping
	public ResponseEntity<List<Doctor>> readAll(){
		try {
			List<Doctor> alma= doctorService.readAll(); 
			if (alma.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(alma, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Doctor> createadoctor(@Valid @RequestBody Doctor c){
		try {
			Doctor  alms= doctorService.create(c); 
			return new ResponseEntity<>(alms, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getadoctor(@PathVariable("id") Long id){
		Optional<Doctor> alms= doctorService.read(id); 
		return alms.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updatedoctor(@PathVariable("id") Long id, @Valid @RequestBody Doctor almas){
		 Optional<Doctor> existing = doctorService.read(id);
	        if (existing.isPresent()) {
	            almas.setId(id);
	            return new ResponseEntity<>(doctorService.update(almas), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletedoctor(@PathVariable("id") Long id) {
        try {
        	doctorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
