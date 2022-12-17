package pe.isil.moduloseguridad.visita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VisitRepository extends JpaRepository<Visita,Long> {

}
