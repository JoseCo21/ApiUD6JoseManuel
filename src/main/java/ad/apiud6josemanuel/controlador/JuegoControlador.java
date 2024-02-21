package ad.apiud6josemanuel.controlador;

import ad.apiud6josemanuel.modelo.Juego;
import ad.apiud6josemanuel.repositorio.JuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/juego")
public class JuegoControlador {
    @Autowired
    private JuegoRepositorio juegoRepositorio;

    //todas las categorias
    @GetMapping
    public List<Juego> obtenerCategorias(){
        return juegoRepositorio.findAll();
    }

    //Categoria por id
    @GetMapping("/{id}")
    public Juego obtenerJuegoId(@PathVariable Long id){
        Optional<Juego> resultado = juegoRepositorio.findById(id);
        return resultado.orElseThrow(() -> new RuntimeException("Juego no encontrado"));

    }

    //Crear categoria
    @PostMapping
    public Juego crearJuego(@RequestBody Juego juego){
        return juegoRepositorio.save(juego);
    }

    //Actualizar categoria
    @PutMapping("/{id}")
    public Juego actualizarJuego(@PathVariable Long id, @RequestBody Juego juego){
        return juegoRepositorio.findById(id)
                .map(juegoTemp -> {
                    juegoTemp.setNombre(juego.getNombre());
                    juegoTemp.setPlataforma(juego.getPlataforma());
                    return juegoRepositorio.save(juegoTemp);
                }).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    //Borrar categoria
    @DeleteMapping("/{id}")
    public void borrarJuego(@PathVariable Long id){
        juegoRepositorio.deleteById(id);

    }

}

