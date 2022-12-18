package pe.isil.moduloseguridad.afiliadoUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Override
    public BasicRespone createAfiliado(Afiliado afiliado) {
        try{
            Optional<Afiliado> userTemp = afiliadoRepository.findByDni(afiliado.getDni());

            if(userTemp.isPresent()){
                return BasicRespone.buildWhenEmailIsTaken();
            }else{
                afiliadoRepository.save(afiliado);
                return BasicRespone.whenSucceed();
            }
        }catch (Exception e){
            return BasicRespone.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicRespone updateAfiliado(Afiliado afiliado, Long id) {
        try{
            Afiliado afiliadoToUpdate = afiliadoRepository.findById(id).get();
            afiliadoToUpdate.setName(afiliado.getName());
            afiliadoToUpdate.setLastName(afiliado.getLastName());
            afiliadoToUpdate.setEmail(afiliado.getEmail());
            afiliadoToUpdate.setDni(afiliado.getDni());
            afiliadoRepository.save(afiliadoToUpdate);
            return BasicRespone.whenSucceed();
        }catch (Exception e){
            return BasicRespone.buildWhenError("DNI ya esta en uso");
        }
    }

    @Override
    public void deleteAfiliado(Long id) {
        Afiliado afiliadoToDelete = afiliadoRepository.findById(id).get();
        afiliadoRepository.delete(afiliadoToDelete);
    }

    @Override
    public Afiliado getAfiliadoByDni(String dni) {
        return afiliadoRepository.findByDni(dni).get();
    }

    @Override
    public Afiliado getAfiliadoById(Long id) {
        return afiliadoRepository.findById(id).get();
    }

    @Override
    public List<Afiliado> findAll() {
        return afiliadoRepository.findAll();
    }


}
