package pe.isil.moduloseguridad.Visita;

import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

public interface VisitaService {


    BasicRespone updateVst(Visita visita, Long id);

    void deleteVst (Long id);

    void save(Visita visita);

    Visita getVstById(Long id);

    List<Visita> getAllVisitas();


}
