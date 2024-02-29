package arrays;

import java.util.Arrays;

public class Maquina {

	/**
	 * Array bidimensional que almacena el nombre de las golosinas
	 */
	static String[][] nombresGolosinas = { { "KitKat", "Chicles de fresa", "Lacasitos", "Palotes" },
			{ "Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix" },
			{ "Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta" },
			{ "Lacasitos", "Crunch", "Milkybar", "KitKat" } };
	
	/**
	 * Array bidimensional que almacena el precio de las golosinas
	 */
	static double[][] precio = {
			  {1.1, 0.8, 1.5, 0.9},
			  {1.8, 1, 1.2, 1},
			  {1.8, 1.3, 1.2, 0.8},
			  {1.5, 1.1, 1.1, 1.1}
			};

	/**
	 * Array bidimensional que almacena el stock
	 */
	static int[][] cantidades = new int[nombresGolosinas.length][nombresGolosinas[0].length];
	
	/**
	 * Array unidimensional que almacena las golosinas vendidas
	 */
	static String[] ventas = new String[0];
	
	/**
	 * Atributo que almacena el precio total de venta
	 */
	static double total = 0;
	
	/**
	 * Constructor vacío
	 */
	public Maquina() {}
	
	/**
	 * Función que rellena la matriz con el número introducido
	 * @param num Número con el que se rellenará el array
	 */
	static void rellenarMatriz(int num) {
		// Rellenamos el array con el número introducido por parámetro
		for (int i = 0; i < cantidades.length; i++) {
			for (int j = 0; j < cantidades[i].length; j++) {
				cantidades[i][j] = num;
			}
		}
	}
	
	/**
	 * Función que muestra el código, el nombre y el precio 
	 * de cada golosina
	 */
	static void mostrarGolosinas() {
		
		for (int i = 0; i < nombresGolosinas.length; i++) {
			for (int j = 0; j < nombresGolosinas[i].length; j++) {
				System.out.println(""+i+""+j + 
						" - " + nombresGolosinas[i][j] +
						" - " + precio[i][j] + " €");
			}
			System.out.println();
		}
	}
	
	/**
	 * Función que valida si la posición es correcta
	 * @param fila Número de fila
	 * @param columna Número de columna
	 * @return Devuelve si la posición es correcta o no
	 */
	static boolean validarPos(int fila, int columna) {
		boolean validada = false;
		
		if ((fila >= 0 & fila < nombresGolosinas.length) &&
			(columna >= 0 & columna < nombresGolosinas[0].length)) {
			validada = true;
		}
			
		return validada;
	}
	
	/**
	 * Función que comprueba si hay más de 0 cantidades de la golosina
	 * seleccionada
	 * @param fila Número de la fila
	 * @param columna Número de la columna
	 * @return Devuelve si hay más de 0 cantidades de la golosina
	 * seleccionada
	 */
	static boolean hayValorPosicion(int fila, int columna) {
		boolean hayStock = false;
		
		if (cantidades[fila][columna] > 0) {
			hayStock = true;
		}
		
		return hayStock;
	}
	
	/**
	 * Función que aumenta la cantidad de las golosinas
	 * @param fila Número de la fila
	 * @param columna Número de la columna
	 * @param cantidad Número de la cantidad a aumentar
	 */
	static void aumentarPosicion(int fila, int columna, int cantidad) {
		cantidades[fila][columna] += cantidad;
	}
	
	/**
	 * Función que reduce la cantidad de las golosinas
	 * @param fila Número de la fila
	 * @param columna Número de la columna
	 * @param cantidad Número de la cantidad a reducir
	 */
	static void reducirPosicion(int fila, int columna, int cantidad) {
		if (cantidades[fila][columna] - cantidad >= 0) {
			cantidades[fila][columna] -= cantidad;
		}
	}
	
	/**
	 * Función que añade la venta
	 * @param fila Número de la fila
	 * @param columna Número de la columna
	 */
	static void anyadirVenta(int fila, int columna) {
		// Copiamos la tabla anterior con una posición más
		ventas = Arrays.copyOfRange(ventas, 0, ventas.length+1);
		
		// Añadimos el valor en la nueva posición
		ventas[ventas.length-1] = nombresGolosinas[fila][columna];
		
		total += precio[fila][columna];
	}
	
	/**
	 * Función que imprime las ventas totales
	 */
	static void imprimirVentasTotales() {
		System.out.println("Golosinas pedidas: ");
		System.out.println(Arrays.toString(ventas));
		
		System.out.println("Precio total de la venta: " + total + " €");
	}
}
