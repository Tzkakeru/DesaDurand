package pe.isil.moduloseguridad.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser,Long> {

    Optional<AuthUser> findAuthUserByEmailAndPassword(String email,String password);

    Optional<AuthUser> findAuthUserByEmail(String email);
}
