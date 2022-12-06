package pe.isil.moduloseguridad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;
import java.util.Optional;

@Service
public class AppIpml implements AppService {

    @Autowired
    private AppRepository appRepository;

    @Override
    public BasicRespone createApp(Aplicacion aplicacion) {
        try{
            Optional<Aplicacion> appTemp = appRepository.findByLenguage(aplicacion.getLenguage());

            if(appTemp.isPresent()){
                return BasicRespone.buildWhenEmailIsTaken();
            }else{
                appRepository.save(aplicacion);
                return BasicRespone.whenSucceed();
            }
        }catch (Exception e){
            return BasicRespone.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicRespone updateApp(Aplicacion aplicacion, Long id) {
        try{
            Aplicacion appToUpdate = appRepository.findById(id).get();
            appToUpdate.setNombre(aplicacion.getNombre());
            appToUpdate.setBaseDatos(aplicacion.getBaseDatos());
            appToUpdate.setLenguage(aplicacion.getLenguage());
            appRepository.save(appToUpdate);
            return BasicRespone.whenSucceed();
        }catch (Exception e){
            return BasicRespone.buildWhenError("El nombre ya esta en uso");
        }
    }

    @Override
    public void deleteApp(Long id) {
        Aplicacion appToDelete = appRepository.findById(id).get();
        appRepository.delete(appToDelete);
    }

   @Override
    public Aplicacion getAppByLenguage(String lenguage) {

        return appRepository.findByLenguage(lenguage).get();
    }

    @Override
    public Aplicacion getAppById(Long id) {
        return appRepository.findById(id).get();
    }

    @Override
    public List<Aplicacion> getAllApps() {
        return appRepository.findAll();
    }
}

