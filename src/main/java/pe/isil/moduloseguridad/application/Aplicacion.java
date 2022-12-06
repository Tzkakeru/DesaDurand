package pe.isil.moduloseguridad.application;

import javax.persistence.*;
import java.util.Date;


@Table(name="tbl_app" , uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombre", name = "unique_nombre")
})
@Entity
public class Aplicacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150 )
    private  String nombre;

    @Column(nullable = true, length = 200 )
    private String baseDatos;

    @Column(nullable = true, length = 200 )
    private String lenguage;

    private Date fechaCreacion;

    private String usuarioCreacion;

    private Date fechaUpdate;

    private String usuarioUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
    }

    @PostPersist
    public void postPersist(){
        this.usuarioCreacion="SYSTEM";
        this.fechaCreacion = new Date();
    }

    @PostUpdate
    public void postUpdate(){
        this.usuarioUpdate="SYSTEM";
        this.fechaUpdate = new Date();
    }


}
