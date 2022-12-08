package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthUserRepository authUserRepository;


    @Override
    public BasicRespone login(String email, String password) {
        try{
            Optional<AuthUser> userToFind = authUserRepository
                    .findAuthUserByEmailAndPassword(email,password);
            if(userToFind.isPresent()){
                if(userToFind.get().getIsActived()){
                    return BasicRespone.buildWhenLoginOk(userToFind.get());
                }else{
                    return BasicRespone.buildWhenIsInactive();
                }
            }else{
                return BasicRespone.buildWhenEmailPasswordIncorrect();
            }
        }catch (Exception e){
            return BasicRespone.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicRespone register(AuthUser authUser) {
        try{
            Optional<AuthUser> authUserToFind = authUserRepository
                    .findAuthUserByEmail(authUser.getEmail());
            if(authUserToFind.isPresent()){
                return BasicRespone.buildWhenEmailIsTaken();
            }else{

                authUserRepository.save(authUser);
                return BasicRespone.buildWhenRegisterSucceed();
            }
        }catch(Exception e){
            return BasicRespone.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicRespone updatePass(AuthUser user){
        try{
            Optional<AuthUser> userTemp = authUserRepository.findAuthUserByEmail(user.getEmail());
            if(userTemp.isEmpty()){
                userTemp.get().setPassword(user.getPassword());
                authUserRepository.save(user);
                return BasicRespone.whenSucceed();

            }else{
                return BasicRespone.buildWhenEmailPasswordIncorrect();
            }
        }catch (Exception e){
            return BasicRespone.buildWhenError(e.getMessage());
        }
    }

    @Override
    public AuthUser getUserByEmail(String Email) {
        return null;
    }


}
