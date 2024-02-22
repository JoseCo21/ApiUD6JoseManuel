package ad.apiud6josemanuel.controlador;

import ad.apiud6josemanuel.modelo.Puntuacion;
import ad.apiud6josemanuel.repositorio.JuegoRepositorio;
import ad.apiud6josemanuel.repositorio.PuntuacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/puntuacion")
public class PuntuacionControlador {
    @Autowired
    private PuntuacionRepositorio puntuacionRepositorio;

    @Autowired
    private JuegoRepositorio juegoRepositorio;

    //Todos los recursos
    @GetMapping
    public List<Puntuacion> obtenerPuntuaciones(){
        return puntuacionRepositorio.findAll(Sort.by(Sort.Direction.DESC,"puntos"));
    }

    //Recurso por id
    @GetMapping("/{id}")
    public Puntuacion obtenerPuntuacionId(@PathVariable Long id){
        Optional<Puntuacion> resultado = puntuacionRepositorio.findById(id);
        return resultado.orElseThrow(() -> new RuntimeException("Puntuacion no encontrada"));

    }

    //Alta de un recurso
    @PostMapping("/juego/{id}")
    public Puntuacion crearPuntuacion(@PathVariable Long id, @RequestBody Puntuacion puntuacion){
        Puntuacion pun= juegoRepositorio.findById(id).map(
                juego -> {
                    puntuacion.setJuego(juego);
                    return puntuacionRepositorio.save(puntuacion);
                }
        ).orElseThrow(() -> new RuntimeException("Juego no encontrado"));
        return pun;
    }

    //Actualizar recurso
    @PutMapping("/{id}")
    public Puntuacion actualizarPuntuacion(@PathVariable Long id, @RequestBody Puntuacion puntuacion){
        return puntuacionRepositorio.findById(id)
                .map(puntuacionTemp -> {
                    puntuacionTemp.setNombre(puntuacion.getNombre());
                    puntuacionTemp.setPuntos(puntuacion.getPuntos());
                    return puntuacionRepositorio.save(puntuacionTemp);
                }).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
    }

    //Borrar recurso
    @DeleteMapping("/{id}")
    public void borrarPuntuacion(@PathVariable Long id){
        puntuacionRepositorio.deleteById(id);

    }
    //Obtener todas las puntuaciones de un juego
    @GetMapping("/juego/{idJuego}")
    public List<Puntuacion> obtenerPuntuacionesJuego(@PathVariable Long idJuego){
        return puntuacionRepositorio.findByJuegoId(idJuego);
    }
}
