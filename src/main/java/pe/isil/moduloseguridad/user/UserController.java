package pe.isil.moduloseguridad.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.shared.BasicRespone;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){

        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "user/index";
    }


    @GetMapping("/create")
    public String createView(Model model){
        return "user/create";
    }

    @PostMapping ("/create")
    public String createUser(Model model, User user){

        BasicRespone response = userService.createUser(user);
        if(response.getCode().equals("200")){
            return "redirect:/user/";
        }else{
            model.addAttribute("resp",response);
            return "./response";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/update";
    }

    @PostMapping("/update")
    public String updateUser(User userToUpdate, Model model){

        BasicRespone response = userService.updateUser(userToUpdate,userToUpdate.getId());
        if(response.getCode().equals("200")){
            return "redirect:/user/";
        }else{
            model.addAttribute("resp",response);
            return "./response";
        }
    }


    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, Model model){
        userService.deleteUser(id);
        return "redirect:/user/";
    }


    @Data
    @Builder
    public static class Response {
        String code;
        String message;
    }

}
