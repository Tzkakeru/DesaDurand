package pe.isil.moduloseguridad.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="tbl_user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email",name="email_unique")
    })
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150 )
    private String name;

    @Column(nullable =true, length =150)
    private String lastName;

    @Column(nullable = false, length = 200)
    private String email;

    @Column(nullable = true, length = 500)
    private String urlPhoto;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;

    @PostPersist
    public void postPersist(){
        this.createdBy="SYSTEM";
        this.createdDate = new Date();
    }

    @PostUpdate
    public void postUpdate(){
        this.updatedBy="SYSTEM";
        this.updatedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
