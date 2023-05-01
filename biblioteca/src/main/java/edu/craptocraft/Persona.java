package edu.craptocraft;

public class Persona {
    private String nombre;
    private String apellidos;
    private String NIF;
    private String contraseña;

    public Persona(String nombre, String apellidos, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        setContraseña(contraseña);
    }

    public Persona(Persona otraPersona) {
        this.nombre = otraPersona.nombre;
        this.apellidos = otraPersona.apellidos;
        this.NIF = otraPersona.NIF;
        this.contraseña = otraPersona.contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        if (contraseña.length() >= 8) {
            this.contraseña = contraseña;
        } else {
            System.out.println("La contraseña debe tener al menos 8 caracteres.");
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Apellidos: " + apellidos + '\n' +
                "NIF: " + NIF + '\n' +
                "Contraseña: " + contraseña + '\n';
    }
}
