package pe.isil.moduloseguridad.visita;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.afiliado.Afiliado;
import pe.isil.moduloseguridad.afiliado.AfiliadoService;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;


@Controller
@RequestMapping("/visita")
public class VisitController {
    @Autowired(required = false)
    private VisitService visitService;

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping("/")
    public String indexVisita(Model model){
        List<Visita> visitas = visitService.getAllVisitas();
        model.addAttribute("visitas",visitas);

        return "visita/indexVst";
    }

    @GetMapping("/create")
    public String createView( Model model){

        List<Afiliado> afiliados=afiliadoService.findAll();
        model.addAttribute("afiliados", afiliados);

        return "visita/createVst";
    }


    @PostMapping("/create")
    public String registrarVisita( Visita visita, Model model) {

        visitService.save(visita);
        return "redirect:/visita/";
    }


    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model){
        Visita vst = visitService.getVstById(id);
        model.addAttribute("vst",vst);
        return "visita/updateVst";
    }


    @PostMapping("/update")
    public String updateApp(Visita vstToUpdate, Model model){

        BasicRespone response = visitService.updateVst(vstToUpdate,vstToUpdate.getId());
        if(response.getCode().equals("200")){
            return "redirect:/visita/";
        }else{
            model.addAttribute("resp",response);
            return "./response";
        }
    }

    @DeleteMapping("/delete")
    public String deleteApp(@RequestParam("id") Long id, Model model){
        visitService.deleteVst(id);
        return "redirect:/visita/";
    }

    @Data
    @Builder
    public static class Response {
        String code;
        String message;
    }
}
