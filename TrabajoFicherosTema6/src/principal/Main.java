package principal;

import java.util.Scanner;

import gestion.*;

public class Main {
	public static void main(String[] args) {
		
		GestionVehiculo lista = new GestionVehiculo();
		
		lista.cargarLista();
		
		desplegarMenu(lista);
		
	}
	
	/**
	 * Funcion que permite al programa acceder a todas las opciones mediante un scanner
	 * @param lista
	 */
	public static void desplegarMenu(GestionVehiculo lista) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		do {
			
		System.out.println("-- Gestion Vehículos --");
		System.out.println("1. Añadir Vehiculo.");
		System.out.println("2. Buscar coche.");
		System.out.println("3. Listar coche.");
		System.out.println("4. Alquilar coche.");
		System.out.println("5. Devolver coche.");
		System.out.println("6. Guardar.");
		System.out.println("0. Salir.");
		
		try {
			opcion = sc.nextInt();
		}catch(Exception e) {
			System.out.println("ERROR: Introduzca un numero entero valido.");
		}
		
		switch(opcion) {
		
		case 0:
			System.out.println("Saliendo del programa.");
			break;
		case 1:
			lista.añadirVehiculo();
			break;
		case 2:
			lista.buscarCoche();
			break;
		case 3:
			lista.listarVehiculos();
			break;
		case 4:
			lista.alquilarCoche();
			break;
		case 5:
			lista.devolverCoche();
			break;
		case 6:
			lista.guardar();
			break;
		default:
			System.out.println("Introduzca una opcion valida.");
		}
		
		}while(opcion != 0);
		
		sc.close();
	}
	
}
