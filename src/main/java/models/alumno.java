
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="alumno")
public class alumno implements Serializable {



    public alumno() {
    }
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_alumno")
    private Integer id_alumno;

    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Telefono")
    private String Telefono;
    
    @Column(name="Email")
    private String Email;

    
    @Column(name="AD")
    private Double AD;
     
    @Column(name="DI")
    private Double DI;

   

 
    @Override
    public String toString() {
        return "alumno{" + "id_alumno=" + id_alumno + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Email=" + Email + ", AD=" + AD + ", DI=" + DI + '}';
    }

    
}
