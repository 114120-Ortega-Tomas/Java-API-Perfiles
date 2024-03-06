package AplicacionPerfiles.AplicacionPerfiles.Repositories;



import AplicacionPerfiles.AplicacionPerfiles.Entities.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilJpaRepository extends JpaRepository<PerfilEntity, Long> {


}
