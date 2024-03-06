package AplicacionPerfiles.AplicacionPerfiles.Controlles;


import AplicacionPerfiles.AplicacionPerfiles.Entities.PerfilEntity;
import AplicacionPerfiles.AplicacionPerfiles.Models.Perfil;
import AplicacionPerfiles.AplicacionPerfiles.Repositories.PerfilJpaRepository;
import AplicacionPerfiles.AplicacionPerfiles.Service.PerfilService;

import jakarta.persistence.CollectionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pefil")
public class PerfilController {

    @Autowired
    private PerfilJpaRepository perfilJpaRepository;
    @Autowired
    private PerfilService perfilService;
    @CrossOrigin(origins = "*")
    @GetMapping("GetAll")
    public ResponseEntity<List<Perfil>> getAll() {
        return ResponseEntity.ok(perfilService.getPerfiles());
    }
    @CrossOrigin(origins = "*")
    @GetMapping("GetbyId")
    public ResponseEntity<Perfil> getAllbyId(Long id) {
        return ResponseEntity.ok(perfilService.getPerfilbyId(id));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("GetAll")
    public ResponseEntity<Perfil> post(@RequestBody PerfilEntity perfilEntity) {
        return ResponseEntity.ok(perfilService.PostPerfil(perfilEntity));
    }
    @CrossOrigin(origins = "*")
    @PostMapping("AccessPerfil")
    public ResponseEntity<Number> post(@RequestParam String email , @RequestParam String password) {
        return ResponseEntity.ok(perfilService.AccessPerfil(email, password));
    }
    @CrossOrigin(origins = "*")
    @PutMapping("UpdatePerfil")
    public ResponseEntity<Perfil> put(@RequestParam Long id  , @RequestBody PerfilEntity perfilEntity) {
        return ResponseEntity.ok(perfilService.UpdatePerfil(id,perfilEntity));
    }






}
