package pe.isil.moduloseguridad.visita;


import pe.isil.moduloseguridad.afiliado.Afiliado;

import javax.persistence.*;
import java.util.Date;

@Table(name="tbl_visitas" , uniqueConstraints = {
        @UniqueConstraint(columnNames = "dni", name = "unique_afiliado")
})
@Entity
public class Visita {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150 )
    private String local;

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    @ManyToOne
    @JoinColumn(name = "dni" )
    private Afiliado afiliado;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }



    private Date fechaHora;

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date updatedDate;

    private String createdBy;

    private String updatedBy;

    @PostPersist
    public void postPersist(){
        this.createdBy="SYSTEM";
        this.fechaHora = new Date();
    }

    @PostUpdate
    public void postUpdate(){
        this.updatedBy="SYSTEM";
        this.updatedDate = new Date();
    }
}
