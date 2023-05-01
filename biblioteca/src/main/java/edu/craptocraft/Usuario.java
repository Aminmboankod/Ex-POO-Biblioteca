package main.java.edu.craptocraft;

public class Usuario extends Persona {

    private ArrayList<Libro> librosReservados;

    public Usuario(String nombre, String apellidos, String NIF, String contraseña) {
        super(nombre, apellidos, NIF, contraseña);
        librosReservados = new ArrayList<>();
    }

    public Usuario(Usuario otro) {
        super(otro);
        librosReservados = new ArrayList<>(otro.librosReservados);
    }

    public ArrayList<Libro> getLibrosReservados() {
        return librosReservados;
    }

    public boolean reservarLibro(Libro libro) {
        if (librosReservados.size() >= 5) {
            System.out.println("No se pueden reservar más de 5 libros");
            return false;
        } else if (libro.getCopiasDisponibles() <= 0) {
            System.out.println("No quedan copias disponibles de este libro");
            return false;
        } else {
            librosReservados.add(libro);
            libro.setCopiasDisponibles(libro.getCopiasDisponibles() - 1);
            System.out.println("Libro reservado con éxito");
            return true;
        }
    }

    public boolean devolverLibro(Libro libro) {
        if (librosReservados.contains(libro)) {
            librosReservados.remove(libro);
            libro.setCopiasDisponibles(libro.getCopiasDisponibles() + 1);
            System.out.println("Libro devuelto con éxito");
            return true;
        } else {
            System.out.println("El libro no está reservado por este usuario");
            return false;
        }
    }
}
