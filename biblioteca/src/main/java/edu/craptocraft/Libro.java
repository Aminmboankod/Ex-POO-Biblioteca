package edu.craptocraft;

import java.util.List;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int numCopias;
    private int numCopiasDisp;
    private static int contadorLibros = 0;

    public Libro() {
        contadorLibros++;
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, int numCopias, int numCopiasDisp) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        if (numCopias >= 1) {
            this.numCopias = numCopias;
        } else {
            this.numCopias = 1;
        }
        this.numCopiasDisp = numCopiasDisp;
        contadorLibros++;
    }

    public Libro(Libro otroLibro) {
        this.ISBN = otroLibro.ISBN;
        this.titulo = otroLibro.titulo;
        this.autor = otroLibro.autor;
        this.editorial = otroLibro.editorial;
        this.numCopias = otroLibro.numCopias;
        this.numCopiasDisp = otroLibro.numCopiasDisp;
        contadorLibros++;
    }

    public String getISBN() {
        return ISBN;
    }

    public void buscarLibroTitulo(String titulo, List<Libro> listaLibros) {
        boolean encontrado = false;
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).titulo.contains(titulo)) {
                System.out.println(listaLibros.get(i).toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se han encontrado libros con el título " + titulo + ".");
        }
    }

    public int getNumCopias() {
        return numCopias;
    }

    public int getNumCopiasDisp() {
        return numCopiasDisp;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Editorial: " + editorial + "\n" +
                "Número de copias: " + numCopias + "\n" +
                "Número de copias disponibles: " + numCopiasDisp + "\n";

    }

    public int getCopiasDisponibles() {
        return 0;
    }

    public void setCopiasDisponibles(int i) {
    }
}
