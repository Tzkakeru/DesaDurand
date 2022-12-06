package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.isil.moduloseguridad.shared.BasicRespone;

@Controller
@RequestMapping("")
public class AuthUserController {

    @Autowired
    private AuthService authService;


    @GetMapping({"","/","/login"})
    public String login(){
        return "auth/login";
    }

    @GetMapping("/auth/register")
    public String register(){
        return "auth/register";
    }



    @PostMapping("/login")
    public String login(@ModelAttribute AuthUser user, Model model){

        BasicRespone result = authService.login(user.getEmail(), user.getPassword());

        if(result.getCode().equals("200")){
            return "redirect:/user/";
        }else{
            model.addAttribute("resp",result);
            return "auth/login";
        }

    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute AuthUser user, Model model){
        BasicRespone result = authService.register(user);
        if(result.getCode().equals("200")){
            return "redirect:/login";
        }else{
            model.addAttribute("resp",result);
            return "index";
        }

    }

}
