package pe.isil.moduloseguridad.Visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;


@Service
public class VisitaImp implements VisitaService {


    @Autowired
    private VisitaRepository visitaRepository;


    public void save(Visita visita){
        visitaRepository.save(visita);
    }

    @Override
    public Visita getVstById(Long id) {
        return visitaRepository.findById(id).get();
    }


    @Override
    public BasicRespone updateVst(Visita visita, Long id) {
        try{
            Visita vstToUpdate = visitaRepository.findById(id).get();
            vstToUpdate.setLocal(visita.getLocal());
            vstToUpdate.setAfiliado(visita.getAfiliado());
            visitaRepository.save(vstToUpdate);
            return BasicRespone.whenSucceed();
        }catch (Exception e){
            return BasicRespone.buildWhenError("El DNI ya esta en uso");
        }
    }
    @Override
    public void deleteVst(Long id) {
        Visita vstsToDelete = visitaRepository.findById(id).get();
        visitaRepository.delete(vstsToDelete);
    }


    @Override
    public List<Visita> getAllVisitas() {
        return visitaRepository.findAll();
    }

}
