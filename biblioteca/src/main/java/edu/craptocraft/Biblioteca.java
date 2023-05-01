package edu.craptocraft;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> listaLibros;
    private List<Persona> listaPersonal;

    public Biblioteca() {
        this.nombre = "";
        this.listaLibros = new ArrayList<Libro>();
        this.listaPersonal = new ArrayList<Persona>();
    }

    public Biblioteca(String nombre, List<Libro> listaLibros, List<Persona> listaPersonal) {
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

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public List<Persona> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(List<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public void mostrarLibros() {
        System.out.println("Lista de libros:");
        for (Libro libro : getListaLibros()) {
            System.out.println(libro.toString());
        }
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Lista de libros disponibles:");
        for (Libro libro : getListaLibros()) {
            if (libro.getCopiasDisponibles() > 0) {
                System.out.println(libro.toString());
            }
        }
    }

    public void eliminarLibro(String ISBN, List<Libro> listaLibros) {
        int posicion = buscarLibroISBN(ISBN, listaLibros);
        if (posicion != -1) {
            if (listaLibros.get(posicion).getNumCopiasDisp() == listaLibros.get(posicion).getNumCopias()) {
                listaLibros.remove(posicion);
                System.out.println("El libro se ha eliminado con éxito.");
            } else {
                System.out.println("El libro tiene reservas y no se puede eliminar.");
            }
        } else {
            System.out.println("No se ha encontrado el libro con ISBN " + ISBN + ".");
        }
    }

    public int buscarLibroISBN(String ISBN, List<Libro> listaLibros) {

        int posicion = -1;

        for (int i = 0; i < listaLibros.size(); i++) {

            if (listaLibros.get(i).getISBN().equals(ISBN)) {
                listaLibros.get(i).toString();
                posicion = i;
                return i;
            }
        }
        return posicion;
    }

    public void añadirPersonal(Persona persona) {
        listaPersonal.add(persona);
    }

    public void eliminarPersonal(String nif) {
        for (Persona persona : listaPersonal) {
            if (persona.getNIF().equals(nif)) {
                listaPersonal.remove(persona);
                break;
            }
        }
    }

    public void añadirBibliotecario(Persona bibliotecario) {
        getListaPersonal().add(bibliotecario);
    }

    public void eliminarBibliotecario(Persona bibliotecario) {
        getListaPersonal().remove(bibliotecario);
    }

    public void añadirLibro(Libro libro) {
        getListaLibros().add(libro);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", listaLibros=" + listaLibros +
                ", listaPersonal=" + listaPersonal +
                '}';
    }

    public void mostrarPersonal() {
        for (Persona persona : listaPersonal) {
            System.out.println(persona.toString());
        }
    }
}
