package AplicacionPerfiles.AplicacionPerfiles.Services;

import AplicacionPerfiles.AplicacionPerfiles.Entities.PerfilEntity;
import AplicacionPerfiles.AplicacionPerfiles.Models.Perfil;
import AplicacionPerfiles.AplicacionPerfiles.Repositories.PerfilJpaRepository;
import AplicacionPerfiles.AplicacionPerfiles.Service.PerfilService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PerfilServiceTest {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private ModelMapper modelMapper;

    @MockBean
    private PerfilJpaRepository perfilJpaRepository;


    //@Override
    //    public Perfil getPerfilbyId(Long id) {
    //        Optional<PerfilEntity> perfilEntity =perfilJpaRepository.findById(id);
    //        if(perfilEntity.isPresent())
    //        {
    //            return modelMapper.map(perfilEntity,Perfil.class);
    //        }
    //        else throw new RuntimeException("El perfil con el id " + id + "no se ah encontrado");
    //    }
    @Test
    public void getPerfilbyIdTest(){
        PerfilEntity perfilEntity = new PerfilEntity(1L,"nombre","apellido","email","password",new Date(),new BigInteger("123"),"pais","ciudad");
        when(perfilJpaRepository.findById(1L)).thenReturn(Optional.of(perfilEntity));
        Perfil esperado = new Perfil(1L,"nombre","apellido","email","password",new Date(),new BigInteger("123"),"pais","ciudad");
        Perfil resultado = perfilService.getPerfilbyId(1L);
        assertEquals(esperado.getApellido(), resultado.getApellido());
        assertEquals(esperado.getEmail(), resultado.getEmail());
    }
    @Test
    public void getPerfilesTest(){
        List<PerfilEntity> perfilEntities = new ArrayList<>();
        perfilEntities.add(new PerfilEntity(1L,"nombre","apellido","email","password",new Date(),new BigInteger("123"),"pais","ciudad"));
        List<Perfil> esperado = new ArrayList<>();
        esperado.add(new Perfil(1L,"nombre","apellido","email","password",new Date(),new BigInteger("123"),"pais","ciudad"));
        List<Perfil> actual = perfilService.getPerfiles();
        assertEquals(esperado,actual);
    }
}
