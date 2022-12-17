package pe.isil.moduloseguridad.afiliado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AfiliadoRepository extends JpaRepository<Afiliado,Long> {

    Optional<Afiliado> findByDni(String dni);

}
