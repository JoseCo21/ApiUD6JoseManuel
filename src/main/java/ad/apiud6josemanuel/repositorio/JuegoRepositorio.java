package ad.apiud6josemanuel.repositorio;

import ad.apiud6josemanuel.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego,Long> {
}
