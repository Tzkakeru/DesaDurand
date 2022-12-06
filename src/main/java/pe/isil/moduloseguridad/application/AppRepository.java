package pe.isil.moduloseguridad.application;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.moduloseguridad.user.User;

import java.util.Optional;

public interface AppRepository extends JpaRepository<Aplicacion,Long> {

    Optional<Aplicacion> findByLenguage(String lenguage);
}
