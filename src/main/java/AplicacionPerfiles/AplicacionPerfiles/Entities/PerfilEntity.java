package AplicacionPerfiles.AplicacionPerfiles.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class PerfilEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column
   private String nombre;
   @Column
   private String apellido;
   @Column
   private String email;
   @Column
   private String password;
   @Column
   private Date fechaNac;
   @Column
   private BigInteger numTel;
   @Column
   private String pais;
   @Column
   private String ciudad;

}
