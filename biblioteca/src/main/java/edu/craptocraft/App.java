package edu.craptocraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Persona> personal = new ArrayList<>();
    private static List<Libro> libros = new ArrayList<>();
    private static Biblioteca biblioteca = new Biblioteca("Biblioteca CIFP FBMoll", libros, personal);

    public static void main(String[] args) {

        /*
         * Primero introducimos datos de prueba para poder probar el programa sin tener
         * que introducir datos cada vez que lo ejecutamos.
         */

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

        /*
         * A continuación, mostramos el menú principal del programa.
         */

        int opcion = -1;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar libros");
            System.out.println("2. Gestionar personal");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    gestionarLibros();
                    break;
                case 2:
                    gestionarPersonal();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
    }

    private static void gestionarLibros() {
        int opcion = -1;
        do {
            System.out.println("=== GESTIÓN DE LIBROS ===");
            System.out.println("1. Mostrar lista de libros");
            System.out.println("2. Mostrar lista de libros disponibles");
            System.out.println("3. Añadir libro");
            System.out.println("4. Eliminar libros");
            System.out.println("5. Buscar libro por ISBN");
            System.out.println("6. Volver al menú principal");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    biblioteca.mostrarLibros();
                    break;
                case 2:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 3:
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Introduce el ISBN del libro:");
                    String isbn = scanner.nextLine();

                    System.out.println("Introduce el título del libro:");
                    String titulo = scanner.nextLine();

                    System.out.println("Introduce el autor del libro:");
                    String autor = scanner.nextLine();

                    System.out.println("Introduce la editorial del libro:");
                    String editorial = scanner.nextLine();

                    System.out.println("Introduce la cantidad total de ejemplares del libro:");
                    int cantidadTotal = scanner.nextInt();

                    System.out.println("Introduce la cantidad de ejemplares disponibles del libro:");
                    int cantidadDisponible = scanner.nextInt();

                    Libro libro = new Libro(isbn, titulo, autor, editorial, cantidadTotal, cantidadDisponible);
                    biblioteca.añadirLibro(libro);
                    System.out.println("Libro añadido correctamente.");
                    break;
                case 4:
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Introduzca el ISBN del libro que desea eliminar: ");
                    String isbnsearch = scanner.nextLine();
                    biblioteca.eliminarLibro(isbnsearch, libros);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Introduzca el ISBN del libro que desea buscar: ");
                    String isbnBusqueda = scanner.nextLine();
                    int posicion = biblioteca.buscarLibroISBN(isbnBusqueda, libros);
                    if (posicion != -1) {
                        System.out.println(libros.get(posicion).toString());
                    } else {
                        System.out.println("El libro no se encuentra en la biblioteca");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 7);
    }

    private static void gestionarPersonal() {
        int opcion = -1;
        do {
            System.out.println("=== GESTIÓN DE PERSONAL ===");
            System.out.println("1. Mostrar lista de personal");
            System.out.println("2. Añadir bibliotecario");
            System.out.println("3. Eliminar bibliotecario");
            System.out.println("4. Volver al menú principal");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    biblioteca.mostrarPersonal();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Introduzca el nombre del nuevo bibliotecario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduzca los apellidos del nuevo bibliotecario: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Introduzca el DNI del nuevo bibliotecario: ");
                    String dni = scanner.nextLine();
                    System.out.print("Introduzca la contraseña del nuevo bibliotecario: ");
                    String password = scanner.nextLine();
                    Persona persona = new Persona(nombre, apellidos, dni, password);
                    biblioteca.añadirPersonal(persona);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Introduzca el DNI del bibliotecario que desea eliminar: ");
                    String dniEliminar = scanner.nextLine();
                    biblioteca.eliminarPersonal(dniEliminar);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 4);
    }
}
