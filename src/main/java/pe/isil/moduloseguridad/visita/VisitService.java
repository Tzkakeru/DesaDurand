package pe.isil.moduloseguridad.visita;

import pe.isil.moduloseguridad.afiliado.Afiliado;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

public interface VisitService {


    BasicRespone updateVst(Visita visita, Long id);

    void deleteVst (Long id);

    void save(Visita visita);

    Visita getVstById(Long id);

    List<Visita> getAllVisitas();


}
