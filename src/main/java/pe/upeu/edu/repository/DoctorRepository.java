package pe.upeu.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upeu.edu.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
