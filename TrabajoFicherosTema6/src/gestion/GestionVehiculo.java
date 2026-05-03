package gestion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase vehiculo la cual implementa un arrayList para recoger una lista de la clase Vehiculo y implementar sus metodos
 */
public class GestionVehiculo {

    final static String archivo = "src/principal/archivo.txt";

    ArrayList<Vehiculo> gestor = new ArrayList<>();

    /**
     * Metodo que permite añadir un vehiculo a la ArrayList
     */
    public void añadirVehiculo() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca la matrícula del vehículo: ");
        String matricula = sc.next().toUpperCase();

        for (Vehiculo vehiculo : gestor) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("ERROR: Ya existe un vehículo con esa matrícula.");
                return;
            }
        }

        System.out.print("Introduzca la marca del vehículo: ");
        String marca = sc.next();

        System.out.print("Introduzca el modelo del vehículo: ");
        String modelo = sc.next();

        Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo);

        gestor.add(vehiculo);
        ordenarVehiculos();

        System.out.println("Vehículo añadido correctamente.");
    }
    
    /**
     * Metodo de la clase gestionVehiculo que permite ordenador la array Vehículo
     */
    public void ordenarVehiculos() {
        gestor.sort(null);
    }
    
    /**
     * Metodo que permite mostrar los datos recogidos en la array al usuario
     */
    public void listarVehiculos() {
        for (Vehiculo vehiculo : gestor) {
            System.out.println(vehiculo);
        }
    }

    /**
     * Metodo que permite guardar los datos ya existentes en el archivo
     */
    public void cargarLista() {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                Vehiculo vehiculo = new Vehiculo(partes[0], partes[1], partes[2]);

                if (partes.length == 4) {
                    vehiculo.alquilado = partes[3].equalsIgnoreCase("No Disponible");
                }

                gestor.add(vehiculo);
            }

            ordenarVehiculos();

        } catch (IOException e) {
            System.out.println("ERROR de lectura de archivo.");
        }
    }
    
    /**
     * Metodo que permite buscar un vehiculo por su matricula
     */
    public void buscarCoche() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca la matrícula del coche a buscar: ");
        String matr = sc.next();

        boolean encontrado = false;

        for (Vehiculo vehiculo : gestor) {

            if (matr.equalsIgnoreCase(vehiculo.matricula)) {
                System.out.println(vehiculo);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }

    /**
     * Metodo que permite cambiar el atributo alquilado del vehiculo a no disponible 
     */
    public void alquilarCoche() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca la matrícula del coche a alquilar: ");
        String matr = sc.next();

        boolean encontrado = false;

        for (Vehiculo vehiculo : gestor) {

            if (matr.equalsIgnoreCase(vehiculo.matricula)) {

                encontrado = true;

                if (!vehiculo.alquilado) {
                    vehiculo.alquilado = true;
                    System.out.println("Vehículo alquilado.");
                } else {
                    System.out.println("Vehículo no disponible.");
                }

                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }

    /**
     * Metodo qye permite cambiar el atributo alquilado del vehiculo a disponible
     */
    public void devolverCoche() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca la matrícula del coche a devolver: ");
        String matr = sc.next();

        boolean encontrado = false;

        for (Vehiculo vehiculo : gestor) {

            if (matr.equalsIgnoreCase(vehiculo.matricula)) {

                encontrado = true;

                if (vehiculo.alquilado) {
                    vehiculo.alquilado = false;
                    System.out.println("Vehículo devuelto.");
                } else {
                    System.out.println("El vehículo ya estaba disponible.");
                }

                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }

    /**
     * Metodo que permite guardar los datos de los vehiculos de la arrayList en el archivo
     */
    public void guardar() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Vehiculo vehiculo : gestor) {

                bw.write(
                    vehiculo.matricula + "," +
                    vehiculo.marca + "," +
                    vehiculo.modelo + "," +
                    (vehiculo.alquilado ? "No Disponible" : "Disponible")
                );

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("ERROR: Escritura del archivo fallida.");
        }
    }
}
