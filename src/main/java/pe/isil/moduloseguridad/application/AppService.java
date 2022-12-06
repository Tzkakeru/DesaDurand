package pe.isil.moduloseguridad.application;

import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

public interface AppService {
    BasicRespone createApp(Aplicacion aplicacion);

    BasicRespone updateApp(Aplicacion aplicacion, Long id);

    void deleteApp (Long id);

    Aplicacion getAppByLenguage(String lenguage);

    Aplicacion getAppById(Long id);
    List<Aplicacion> getAllApps();
}
