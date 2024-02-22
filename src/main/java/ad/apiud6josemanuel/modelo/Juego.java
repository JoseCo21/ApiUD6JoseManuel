package ad.apiud6josemanuel.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity(name = "juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank(message = "El nombre no puede estar vacio")
    String nombre;
    @NotBlank(message = "La plataforma no puede estar vacia")
    String plataforma;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Puntuacion> puntuaciones;

    public Juego() {
    }

    public Juego(String nombre, String plataforma) {
        this.nombre = nombre;
        this.plataforma = plataforma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
