package pe.isil.moduloseguridad.application;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired(required = false)
    private AppService appService;

    @GetMapping("/")
    public String indexApp(Model model){

        List<Aplicacion> apps = appService.getAllApps();
        model.addAttribute("apps",apps);

        return "app/indexApp";
    }

    @GetMapping("/create")
    public String createView(Model model){
        return "app/createApp";
    }

    @PostMapping("/create")
    public String createApp(Model model, Aplicacion aplicacion){

        BasicRespone response = appService.createApp(aplicacion);
        if(response.getCode().equals("200")){
            return "redirect:/app/";
        }else{
            model.addAttribute("resp",response);
            return "./response";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model){
        Aplicacion aplicacion = appService.getAppById(id);
        model.addAttribute("app",aplicacion);
        return "app/updateApp";
    }

    @PostMapping("/update")
    public String updateApp(Aplicacion appToUpdate, Model model){

        BasicRespone response = appService.updateApp(appToUpdate,appToUpdate.getId());
        if(response.getCode().equals("200")){
            return "redirect:/app/";
        }else{
            model.addAttribute("resp",response);
            return "./response";
        }
    }

    @DeleteMapping("/delete")
    public String deleteApp(@RequestParam("id") Long id, Model model){
        appService.deleteApp(id);
        return "redirect:/app/";
    }

    @Data
    @Builder
    public static class Response {
        String code;
        String message;
    }
}
