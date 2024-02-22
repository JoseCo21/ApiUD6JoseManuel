package ad.apiud6josemanuel.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "puntuaciones")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank(message = "El nombre no puede estar vacio")
    String nombre;
    @Min(value = 0, message = "La puntuacion tiene que ser mayor a 0")
    int puntos;
    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;

    public Puntuacion() {
    }

    public Puntuacion(String nombre, int puntos, Juego juego) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.juego = juego;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
