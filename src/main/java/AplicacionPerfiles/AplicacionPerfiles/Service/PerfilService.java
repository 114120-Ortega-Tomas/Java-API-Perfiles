package AplicacionPerfiles.AplicacionPerfiles.Service;



import AplicacionPerfiles.AplicacionPerfiles.Entities.PerfilEntity;
import AplicacionPerfiles.AplicacionPerfiles.Models.Perfil;

import org.apache.tomcat.util.net.jsse.PEMFile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PerfilService {

    List<Perfil> getPerfiles();
    Perfil getPerfilbyId(Long id);
    Perfil PostPerfil(PerfilEntity perfilEntity);
    Number AccessPerfil(String email , String password);
    Perfil UpdatePerfil(Long id , PerfilEntity perfilEntity);

}
