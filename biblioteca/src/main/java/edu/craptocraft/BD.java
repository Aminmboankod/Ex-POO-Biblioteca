package edu.craptocraft;

import java.util.ArrayList;
import java.util.List;

public class BD {

    private List<Persona> personal = new ArrayList<>();
    private List<Libro> libros = new ArrayList<>();
    private Biblioteca biblioteca = new Biblioteca("Biblioteca CIFP FBMoll", libros, personal);

    public BD() {
        añadirDatos();
    }

    /*
     * Primero introducimos datos de prueba para poder probar el programa sin tener
     * que introducir datos cada vez que lo ejecutamos.
     */
    public void añadirDatos() {
        personal.add(new Persona("Juan", "García", "12345678A", "password1"));
        personal.add(new Persona("María", "Sánchez", "87654321B", "password2"));
        personal.add(new Persona("Pedro", "Martínez", "11111111C", "password3"));

        for (Persona persona : personal) {
            biblioteca.añadirPersonal(persona);
        }

        libros.add(new Libro("9788467842564", "El Quijote", "Miguel de Cervantes", "Anaya", 5, 3));
        libros.add(new Libro("9788498382543", "La Casa de Bernarda Alba", "Federico García Lorca", "Cátedra", 3, 1));
        libros.add(new Libro("9788420669217", "Crónica de una muerte anunciada", "Gabriel García Márquez", "Alfaguara",
                2, 2));

        for (Libro libro : libros) {
            biblioteca.añadirLibro(libro);
        }
    }
}
