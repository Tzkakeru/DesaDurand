package pe.isil.moduloseguridad.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public BasicRespone createUser(User user) {
        try{
            Optional<User> userTemp = userRepository.findByEmail(user.getEmail());

            if(userTemp.isPresent()){
                return BasicRespone.buildWhenEmailIsTaken();
            }else{
                userRepository.save(user);
                return BasicRespone.whenSucceed();
            }
        }catch (Exception e){
            return BasicRespone.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicRespone updateUser(User user, Long id) {
        try{
            User userToUpdate = userRepository.findById(id).get();
            userToUpdate.setName(user.getName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setUrlPhoto(user.getUrlPhoto());
            userRepository.save(userToUpdate);
            return BasicRespone.whenSucceed();
        }catch (Exception e){
            return BasicRespone.buildWhenError("Correo ya esta en uso");
        }
    }

    @Override
    public void deleteUser(Long id) {
        User userToDelete = userRepository.findById(id).get();
        userRepository.delete(userToDelete);
    }

    @Override
    public User getUserByMail(String mail) {

        return userRepository.findByEmail(mail).get();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
