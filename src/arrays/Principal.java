package arrays;

import java.util.Scanner;

public class Principal {

	// Creamos el Scanner estático
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Variable donde se almacenará la opción elegida por el usuario
		int opcion;
		
		
		// Rellenamos la tabla de cantidades inicialmente a 5
		Maquina.rellenarMatriz(5);
		
		// Le mostramos el menú al usuario mientras no elija 'Apagar la máquina'
		do {
			// Mostramos el menú
			menu();
			
			// Leemos la opción elegida por el usuario
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 1:
					Maquina.mostrarGolosinas();
					break;
				case 2:
					pedirGolosinas();
					break;
				case 3:
					tecnico();
					break;
				case 4:
					Maquina.imprimirVentasTotales();
					break;
			}
			
		} while (opcion != 4);
		
		// Cerramos el Scanner
		sc.close();
	}
	
	static void tecnico() {
		String password = "";
		int codigo;
		int fila;
		int columna;
		
		System.out.println("Introduzca la contraseña: ");
		sc.nextLine();
		password = sc.nextLine();
		
		if (password.equals("Maquina2023")) {
			
			System.out.println("Introduzca el código de la golosina");
			codigo = sc.nextInt();
			
			fila = codigo /10;
			columna = codigo %10;
			
			if (Maquina.validarPos(fila, columna)) {
				
				Maquina.aumentarPosicion(fila, columna, 1);
				
			} else {
				System.out.println("Codigo incorrecto, pa tu casa");
			}
			
		} else {
			System.out.println("Contraseña incorrecta, adiós pringao");
		}
	}
	
	static void pedirGolosinas() {
		int codigo;
		
		int fila;
		int columna;
		
		System.out.println("Introduce el código de la golosina");
		
		codigo = sc.nextInt();
		
		fila = codigo / 10;
		columna = codigo % 10;
		
		if (Maquina.validarPos(fila, columna)) {
			
			if (Maquina.hayValorPosicion(fila, columna)) {
				
				Maquina.anyadirVenta(fila, columna);
				
				Maquina.reducirPosicion(fila, columna, 1);
				
				System.out.println("Aquí esta tu gominola");
				
			} else {
				System.out.println("No quedan de esas");
			}
			
		} else {
			System.out.println("Código incorrecto");
		}
	}
	
	/**
	 * Función que imprime el menú
	 */
	static void menu() {
		System.out.println(
				"¿Qué desea hacer?\n" +
				"1. Mostrar golosinas\n" +
				"2. Pedir golosinas\n" +
				"3. Rellenar golosinas\n" +
				"4. Apagar máquina"
		);
	}
	
}
