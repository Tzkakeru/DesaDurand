package pe.isil.moduloseguridad.afiliadoUser;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

@Controller
@RequestMapping("/afiliado")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping("/")
    public String index(Model model){

        List<Afiliado> afiliados = afiliadoService.findAll();
        model.addAttribute("afiliados", afiliados);

        return "afiliado/index";
    }


    @GetMapping("/create")
    public String createView(Model model){
        return "afiliado/create";
    }

    @PostMapping ("/create")
    public String createUser(Model model, Afiliado afiliado){

        BasicRespone response = afiliadoService.createAfiliado(afiliado);
        if(response.getCode().equals("200")){
            return "redirect:/afiliado/";
        }else{
            model.addAttribute("resp",response);
            return "./response";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model){
        Afiliado afil = afiliadoService.getAfiliadoById(id);
        model.addAttribute("afil", afil);
        return "afiliado/update";
    }

    @PostMapping("/update")
    public String updateUser(Afiliado afiliadoToUpdate, Model model){

        BasicRespone response = afiliadoService.updateAfiliado(afiliadoToUpdate, afiliadoToUpdate.getId());
        if(response.getCode().equals("200")){
            return "redirect:/afiliado/";
        }else{
            model.addAttribute("resp",response);
            return "./response";
        }
    }


    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, Model model){
        afiliadoService.deleteAfiliado(id);
        return "redirect:/afiliado/";
    }


    @Data
    @Builder
    public static class Response {
        String code;
        String message;
    }

}
