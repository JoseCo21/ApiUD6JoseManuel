package ad.apiud6josemanuel.repositorio;

import ad.apiud6josemanuel.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionRepositorio extends JpaRepository<Puntuacion,Long> {
}
