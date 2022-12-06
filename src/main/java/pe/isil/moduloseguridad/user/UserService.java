package pe.isil.moduloseguridad.user;

import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

public interface UserService {

    BasicRespone createUser(User user);
    BasicRespone updateUser(User user, Long id);

    void deleteUser(Long id);

    User getUserByMail(String mail);
    User getUserById(Long id);
    List<User> getAllUsers();
}
