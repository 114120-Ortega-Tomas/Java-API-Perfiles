package AplicacionPerfiles.AplicacionPerfiles.Service.Impl;


import AplicacionPerfiles.AplicacionPerfiles.Entities.PerfilEntity;
import AplicacionPerfiles.AplicacionPerfiles.Models.Perfil;
import AplicacionPerfiles.AplicacionPerfiles.Repositories.PerfilJpaRepository;
import AplicacionPerfiles.AplicacionPerfiles.Service.PerfilService;

import org.hibernate.validator.internal.metadata.descriptor.PropertyDescriptorImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImplementacion implements PerfilService {



   @Autowired
    private PerfilJpaRepository perfilJpaRepository;
   @Autowired
   private ModelMapper modelMapper;

    @Override
    public List<Perfil> getPerfiles() {
        List<PerfilEntity> lista = perfilJpaRepository.findAll();
        List<Perfil> listaActual = modelMapper.map(lista, List.class);
        return listaActual;
    }

    @Override
    public Perfil getPerfilbyId(Long id) {
        Optional<PerfilEntity> perfilEntity =perfilJpaRepository.findById(id);
        if(perfilEntity.isPresent())
        {
            return modelMapper.map(perfilEntity,Perfil.class);
        }
        else throw new RuntimeException("El perfil con el id " + id + "no se ah encontrado");
    }

    @Override
    public Perfil PostPerfil(PerfilEntity perfilEntity) {
        perfilJpaRepository.save(perfilEntity);
        return modelMapper.map(perfilEntity,Perfil.class);
    }

    @Override
    public Number AccessPerfil(String email, String password) {
        List<PerfilEntity> perfiles = perfilJpaRepository.findAll();
        for (PerfilEntity perfilEntity : perfiles)
        {
            if(perfilEntity.getEmail().equals(email) && perfilEntity.getPassword().equals(password))
            {
               return perfilEntity.getId();
            }

        }
         throw new RuntimeException("CORROBORE LOS DATOS INGRESADOS");
    }

    @Override
    public Perfil UpdatePerfil(Long id, PerfilEntity perfilEntity) {
        Optional<PerfilEntity> perfilEntity1 = perfilJpaRepository.findById(id);
        if(!perfilEntity1.isPresent())
        {
            throw new RuntimeException("NO EXISTE EL PERFIL CON EL ID " + id);

        }
        else{
            perfilEntity1.get().setApellido(perfilEntity.getApellido());
            perfilEntity1.get().setEmail(perfilEntity.getEmail());
            perfilEntity1.get().setNombre(perfilEntity.getNombre());
            perfilEntity1.get().setPassword(perfilEntity.getPassword());
            perfilEntity1.get().setFechaNac(perfilEntity.getFechaNac());
            perfilEntity1.get().setNumTel(perfilEntity.getNumTel());
            perfilEntity1.get().setPais(perfilEntity.getPais());
            perfilEntity1.get().setCiudad(perfilEntity.getCiudad());
            perfilJpaRepository.save(perfilEntity1.get());
        }
        return modelMapper.map(perfilEntity,Perfil.class);
    }
}
