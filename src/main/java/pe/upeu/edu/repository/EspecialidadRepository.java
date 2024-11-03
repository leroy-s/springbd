package pe.upeu.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upeu.edu.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long>{

}
