/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Sala de Sistemas
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Usuario {
    private String nombreCompleto;
    private String nickname;
    private String clave;
    private String tipo;
    private String fechaCreacion;
    
    public Usuario(String nombreCompleto, String nickname, String clave, String tipo, String fechaCreacion) {
        this.nombreCompleto = nombreCompleto;
        this.nickname = nickname;
        this.clave = clave;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNickname() {
        return nickname;
    }

    public String getClave() {
        return clave;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String toString() {
        return "Nombre Completo: " + nombreCompleto + "\n" +
               "Nickname: " + nickname + "\n" +
               "Clave: " + clave + "\n" +
               "Tipo: " + tipo + "\n" +
               "Fecha de Creación: " + fechaCreacion;
    }
}

public class usuario {
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarUsuario();
                    break;
                case 2:
                    buscarUsuario();
                    break;
                case 3:
                    eliminarUsuario();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Buscar Usuario");
        System.out.println("3. Eliminar Usuario");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void agregarUsuario() {
        System.out.print("Ingrese el nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese el nickname: ");
        String nickname = scanner.nextLine();
        System.out.print("Ingrese la clave: ");
        String clave = scanner.nextLine();
        System.out.print("Ingrese el tipo de usuario: ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese la fecha de creación (formato YYYY-MM-DD): ");
        String fechaCreacion = scanner.nextLine();

        Usuario usuario = new Usuario(nombreCompleto, nickname, clave, tipo, fechaCreacion);
        usuarios.put(nickname, usuario);
        System.out.println("Usuario agregado correctamente.");
    }

    private static void buscarUsuario() {
        System.out.print("Ingrese el nickname del usuario a buscar: ");
        String nickname = scanner.nextLine();
        Usuario usuario = usuarios.get(nickname);
        if (usuario != null) {
            System.out.println("Datos del Usuario:\n" + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void eliminarUsuario() {
        System.out.print("Ingrese el nickname del usuario a eliminar: ");
        String nickname = scanner.nextLine();
        if (usuarios.containsKey(nickname)) {
            usuarios.remove(nickname);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}


