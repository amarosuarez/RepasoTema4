package cadenas;

import java.util.Scanner;

public class Principal {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena = "";
		
		int opcion;
		
		Ahorcado.generaPalabra();
		
		Ahorcado.pintaPista();
		
		do {
			
			opcion = menu();
			
			sc.nextLine();
			
			switch(opcion) {
				case 1:
					System.out.println("Introduce una letra");
					cadena = sc.nextLine();
					Ahorcado.compruebaLetra(String.valueOf(cadena.charAt(0)));
					break; 
				case 2:
					System.out.println("Introduce la palabra");
					cadena = sc.nextLine();
					Ahorcado.compruebaPalabra(cadena);
					break;
				default:
					opcion = menu();
					break;
			}

			
			Ahorcado.pintaPista();
			System.out.println("Te quedan " + (Ahorcado.NUMINTENTOS - Ahorcado.intentosActuales) + " intentos");
			
		} while (Ahorcado.intentosActuales < Ahorcado.NUMINTENTOS && !Ahorcado.palabraPista.equalsIgnoreCase(Ahorcado.palabraSecreta));
		
			
		if (Ahorcado.intentosActuales < 7) {
			System.out.println("¡¡ENHORABUENA!! HAS ACERTADO");
		} else {
			System.out.println("Game over");
		}
	}
	
	static int menu() {
		int opcion;
		
		System.out.println(
			"Seleccione una de las siguientes opciones:\n" +
			"1. Introducir letra.\n" +
			"2. Introducir palabra.\n"
		);
		
		opcion = sc.nextInt();
		
		return opcion;
	}
	
}
