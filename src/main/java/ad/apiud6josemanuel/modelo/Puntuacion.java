package ad.apiud6josemanuel.modelo;

import jakarta.persistence.*;

@Entity(name = "puntuaciones")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombre;
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
