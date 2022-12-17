package pe.isil.moduloseguridad.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.afiliado.Afiliado;
import pe.isil.moduloseguridad.afiliado.AfiliadoRepository;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;


@Service
public class VisitImpl implements VisitService {


    @Autowired
    private VisitRepository visitRepository;

    public void save(Visita visita){
        visitRepository.save(visita);
    }

    @Override
    public Visita getVstById(Long id) {
        return visitRepository.findById(id).get();
    }


    @Override
    public BasicRespone updateVst(Visita visita, Long id) {
        try{
            Visita vstToUpdate = visitRepository.findById(id).get();
            vstToUpdate.setLocal(visita.getLocal());
            vstToUpdate.setAfiliado(visita.getAfiliado());
            visitRepository.save(vstToUpdate);
            return BasicRespone.whenSucceed();
        }catch (Exception e){
            return BasicRespone.buildWhenError("El DNI ya esta en uso");
        }
    }
    @Override
    public void deleteVst(Long id) {
        Visita vstsToDelete = visitRepository.findById(id).get();
        visitRepository.delete(vstsToDelete);
    }


    @Override
    public List<Visita> getAllVisitas() {
        return visitRepository.findAll();
    }

}
