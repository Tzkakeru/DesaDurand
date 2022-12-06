package pe.isil.moduloseguridad.auth;

import pe.isil.moduloseguridad.shared.BasicRespone;

public interface AuthService {

    BasicRespone login(String email, String password);
    BasicRespone register(AuthUser authUser);

}
