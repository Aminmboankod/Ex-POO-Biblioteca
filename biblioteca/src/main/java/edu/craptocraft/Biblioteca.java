package main.java.edu.craptocraft;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Personal> listaPersonal;

    public Biblioteca() {
        this.nombre = "";
        this.listaLibros = new ArrayList<Libro>();
        this.listaPersonal = new ArrayList<Personal>();
    }

    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Personal> listaPersonal) {
        this.nombre = nombre;
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }

    public Biblioteca(Biblioteca biblioteca) {
        this.nombre = biblioteca.nombre;
        this.listaLibros = biblioteca.listaLibros;
        this.listaPersonal = biblioteca.listaPersonal;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 0) {
            this.nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
        }
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Personal> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList<Personal> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public void mostrarLibros() {
        System.out.println("Lista de libros:");
        for (Libro libro : listaLibros) {
            System.out.println(libro.toString());
        }
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Lista de libros disponibles:");
        for (Libro libro : listaLibros) {
            if (libro.getNumCopiasDisponibles() > 0) {
                System.out.println(libro.toString());
            }
        }
    }

    public void aniadirPersonal(Persona persona) {
        listaPersonal.add(persona);
    }

    public void eliminarPersonal(String nif) {
        for (Persona persona : listaPersonal) {
            if (persona.getNif().equals(nif)) {
                listaPersonal.remove(persona);
                break;
            }
        }
    }

    public void añadirBibliotecario(Persona bibliotecario) {
        listaPersonal.add(bibliotecario);
    }

    public void eliminarBibliotecario(Persona bibliotecario) {
        listaPersonal.remove(bibliotecario);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", listaLibros=" + listaLibros +
                ", listaPersonal=" + listaPersonal +
                '}';
    }
}
