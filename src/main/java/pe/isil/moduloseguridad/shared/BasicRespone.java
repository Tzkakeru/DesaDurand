package pe.isil.moduloseguridad.shared;

import lombok.Builder;
import lombok.Data;
import pe.isil.moduloseguridad.auth.AuthUser;

@Data
@Builder
public class BasicRespone {

    private String code;
    private String message;
    private Object data;

    public static BasicRespone buildWhenLoginOk(AuthUser user) {
        return BasicRespone.builder()
                .code("200")
                .message("Login Exitoso")
                .data(user)
                .build();
    }

    public static BasicRespone whenSucceed(){
        return BasicRespone.builder()
                .code("200")
                .message("Operacion correcta")
                .build();
    }

    public static BasicRespone buildWhenError(String error){
        return BasicRespone.builder()
                .code("500")
                .message("Ocurrio un error ".concat(error) )
                .build();
    }

    public static BasicRespone buildWhenIsInactive(){
        return BasicRespone.builder()
                .code("401")
                .message("User inactivo")
                .build();
    }

    public static BasicRespone buildWhenEmailPasswordIncorrect(){
        return BasicRespone.builder()
                .code("403")
                .message("Correo o password incorrecto")
                .build();
    }

    public static BasicRespone buildWhenEmailIsTaken(){
        return BasicRespone.builder()
                .code("510")
                .message("Usuario ya esta registrado")
                .build();
    }
    public static BasicRespone buildWhenApplIsTaken(){
        return BasicRespone.builder()
                .code("510")
                .message("App ya esta registrada")
                .build();
    }


    public static BasicRespone buildWhenRegisterSucceed(){
        return BasicRespone.builder()
                .code("200")
                .message("Usuario registrado correctamente")
                .build();
    }

}
