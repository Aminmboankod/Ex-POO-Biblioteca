package edu.craptocraft;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca("Biblioteca del CIFP FBMoll");

    public static void main(String[] args) {
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
            System.out.println("4. Eliminar libro");
            System.out.println("5. Buscar libro por ISBN");
            System.out.println("6. Buscar libro por título");
            System.out.println("7. Volver al menú principal");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(biblioteca.mostrarLibros());
                    break;
                case 2:
                    System.out.println(biblioteca.mostrarLibrosDisponibles());
                    break;
                case 3:
                    biblioteca.addLibro();
                    break;
                case 4:
                    biblioteca.eliminarLibro();
                    break;
                case 5:
                    biblioteca.buscarLibroPorISBN();
                    break;
                case 6:
                    biblioteca.buscarLibroPorTitulo();
                    break;
                case 7:
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
                    System.out.println(biblioteca.mostrarPersonal());
                    break;
                case 2:
                    biblioteca.addBibliotecario();
                    break;
                case 3:
                    biblioteca.eliminarBibliotecario();
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
