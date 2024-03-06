package AplicacionPerfiles.AplicacionPerfiles.Models;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data@AllArgsConstructor@NoArgsConstructor
public class Perfil {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Date fechaNac;
    private BigInteger numTel;
    private String pais;
    private String ciudad;
}
