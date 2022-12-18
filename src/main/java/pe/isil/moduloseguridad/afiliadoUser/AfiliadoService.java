package pe.isil.moduloseguridad.afiliadoUser;

import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

public interface AfiliadoService {

    BasicRespone createAfiliado(Afiliado afiliado);
    BasicRespone updateAfiliado(Afiliado afiliado, Long id);

    void deleteAfiliado(Long id);

    Afiliado getAfiliadoByDni(String dni);
    Afiliado getAfiliadoById(Long id);
    List<Afiliado> findAll();


}
